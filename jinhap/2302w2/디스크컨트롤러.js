function solution(jobs) {
	let answer = 0;
	const q = new PriorityQueue();

	jobs.sort((a, b) => {
		if (a[0] !== b[0]) return a[0] - b[0];
		return a[1] - b[1];
	});

	let j = 0;
	let time = 0;
	while (j < jobs.length || q.arr.length > 1) {
		if (jobs.length > j && time >= jobs[j][0]) {
			q.push(jobs[j][1], jobs[j++]);
			continue;
		}
		if (q.arr.length > 1) {
			const task = q.pop();
			time += task[0];
			answer += time - task[1][0];
		} else {
			time = jobs[j][0];
		}
	}
	return parseInt(answer / jobs.length);
}

class PriorityQueue {
	constructor() {
		this.arr = [];
		this.arr.push('');
	}
	push(cost, elem) {
		this.arr.push([cost, elem]);
		let cur = this.arr.length - 1;
		while (cur > 1) {
			let parent = Math.floor(cur / 2);
			let tmp = this.arr[parent];
			if (this.arr[parent][0] > this.arr[cur][0]) {
				this.arr[parent] = this.arr[cur];
				this.arr[cur] = tmp;
			} else {
				break;
			}
			cur = parent;
		}
	}
	pop() {
		if (this.arr.length <= 1) return null;
		let cur = 1;
		const last = this.arr[cur];
		if (this.arr.length === 2) this.arr.pop();
		else this.arr[cur] = this.arr.pop();

		while (cur * 2 < this.arr.length) {
			const left = cur * 2;
			const right = cur * 2 + 1;
			if (
				right < this.arr.length &&
				this.arr[right][0] < this.arr[left][0] &&
				this.arr[right][0] < this.arr[cur][0]
			) {
				let tmp = this.arr[cur];
				this.arr[cur] = this.arr[right];
				this.arr[right] = tmp;
				cur = right;
			} else if (this.arr[left][0] < this.arr[cur][0]) {
				let tmp = this.arr[cur];
				this.arr[cur] = this.arr[left];
				this.arr[left] = tmp;
				cur = left;
			} else {
				break;
			}
		}
		return last;
	}
}
