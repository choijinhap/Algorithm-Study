function solution(k, ranges) {
	const answer = [];
	const y = [];
	const cnt = collatz(k, y, 0);
	const areas = [0];
	for (let i = 1; i < y.length; i++) {
		areas.push(Math.min(y[i], y[i - 1]) + Math.abs(y[i] - y[i - 1]) / 2);
	}
	ranges.forEach(([a, b]) => {
		answer.push(getArea(areas, a, b));
	});
	return answer;
}

function getArea(areas, a, b) {
	let answer = 0;
	if (a >= areas.length + b) return -1;
	for (let i = a + 1; i < areas.length + b; i++) {
		answer += areas[i];
	}
	return answer;
}

function collatz(n, arr, cnt) {
	if (cnt >= 200) return cnt;
	arr.push(n);
	if (n === 1) {
		return cnt + 1;
	}
	if (n % 2 == 0) {
		return collatz(n / 2, arr, cnt + 1);
	}
	return collatz(n * 3 + 1, arr, cnt + 1);
}
