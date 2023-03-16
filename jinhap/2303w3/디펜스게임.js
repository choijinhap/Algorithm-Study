//힙
function solution(n, k, enemy) {
	const queue = new MaxHeap();
	let life = n;
	let restShield = k;
	let answer = 0;
	for (let i = 0; i < enemy.length; i++) {
		const damage = enemy[i];
		life -= damage;
		queue.push(damage);
		if (life >= 0) {
			answer++;
		} else if (restShield > 0) {
			life += queue.pop();
			answer++;
			restShield--;
		}
	}
	return answer;
}

class MaxHeap {
	constructor() {
		this.arr = [];
	}
	size() {
		return this.arr.length;
	}
	push(el) {
		if (this.arr.length === 0) {
			this.arr.push(el);
			return;
		}
		this.arr.push(el);
		let curIdx = this.arr.length - 1;
		while (curIdx > 0) {
			const parentIdx = Math.floor((curIdx - 1) / 2);
			if (this.arr[curIdx] > this.arr[parentIdx]) {
				this.swap(curIdx, parentIdx);
			} else {
				break;
			}
			curIdx = parentIdx;
		}
	}
	pop() {
		const max = this.arr[0];
		this.swap(0, this.arr.length - 1);
		this.arr.pop();
		let cur = 0;
		let leftIdx = cur * 2 + 1;
		let rightIdx = cur * 2 + 2;
		while (leftIdx < this.arr.length) {
			if (rightIdx < this.arr.length) {
				if (this.arr[leftIdx] < this.arr[rightIdx] && this.arr[cur] < this.arr[rightIdx]) {
					this.swap(cur, rightIdx);
					cur = rightIdx;
				} else if (this.arr[cur] < this.arr[leftIdx]) {
					this.swap(cur, leftIdx);
					cur = leftIdx;
				} else break;
			} else {
				if (this.arr[cur] < this.arr[leftIdx]) {
					this.swap(cur, leftIdx);
					cur = leftIdx;
				} else break;
			}
			leftIdx = cur * 2 + 1;
			rightIdx = cur * 2 + 2;
		}

		return max;
	}
	peek() {
		return this.arr[0];
	}
	swap(idx1, idx2) {
		const tmp = this.arr[idx1];
		this.arr[idx1] = this.arr[idx2];
		this.arr[idx2] = tmp;
	}
}
