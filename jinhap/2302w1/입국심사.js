/*
이분탐색 시간초과...

function solution(n, times) {
	let left = 0;
	let right = (Math.max(...times) / times.length) * n;
	while (left <= right) {
		const mid = ((left + right) / 2) >> 0;
		if (check(mid)) {
			right = mid - 1;
		} else {
			left = mid + 1;
		}
	}
	return right + 1;
	function check(time) {
		let cnt = 0;
		for (let i = 0; i < times.length; i++) {
			cnt += (time / times[i]) >> 0;
			if (cnt >= n) return true;
		}
		return false;
	}
}

*/

// >> 연산이 Math.floor() 보다 비싼듯하다 어이가 없네
function solution(n, times) {
	let left = 0;
	let right = (Math.max(...times) / times.length) * n;
	while (left <= right) {
		const mid = Math.floor((left + right) / 2);
		if (check(mid)) {
			right = mid - 1;
		} else {
			left = mid + 1;
		}
	}
	return right + 1;
	function check(time) {
		let cnt = 0;
		for (let i = 0; i < times.length; i++) {
			cnt += Math.floor(time / times[i]);
			if (cnt >= n) return true;
		}
		return false;
	}
}
