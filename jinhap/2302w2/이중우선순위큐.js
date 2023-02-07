function solution(operations) {
	const pq = new PriorityQueue();
	operations.forEach((operation) => {
		const [op, num] = operation.split(' ');
		if (op === 'I') {
			pq.push(Number(num));
		} else {
			if (num === '1') {
				pq.popMax();
			} else {
				pq.popMin();
			}
		}
		console.log(pq.arr);
	});
	if (pq.arr.length < 2) return [0, 0];
	return [pq.popMax(), pq.popMin()];
}
class PriorityQueue {
	constructor() {
		this.arr = [null];
	}
	push(cost) {
		this.arr.push(cost);
		let cur = this.arr.length - 1;

		while (cur > 1) {
			const parent = Math.floor(cur / 2);
			const parentCost = this.arr[parent];
			if (cost < parentCost) {
				this.swap(cur, parent);
				cur = parent;
			} else {
				break;
			}
		}
	}

	popMin() {
		if (this.arr.length === 1) return null;
		if (this.arr.length === 2) return this.arr.pop();
		let last = this.arr[1];
		let cur = 1;
		this.arr[cur] = this.arr.pop();
		while (cur * 2 < this.arr.length) {
			const left = cur * 2;
			const right = cur * 2 + 1;
			if (
				right < this.arr.length &&
				this.arr[right] < this.arr[left] &&
				this.arr[right] < this.arr[cur]
			) {
				this.swap(cur, right);
				cur = right;
			} else if (this.arr[left] < this.arr[cur]) {
				this.swap(cur, left);
				cur = left;
			} else {
				break;
			}
		}

		return last;
	}

	popMax() {
		if (this.arr.length === 1) return null;
		const max = Math.max(...this.arr);
		this.swap(this.arr.indexOf(max), this.arr.length - 1);
		return this.arr.pop();
	}
	swap(a, b) {
		[this.arr[a], this.arr[b]] = [this.arr[b], this.arr[a]];
	}
}
