function solution(n) {
	let result = [];
	move(n, 1, 3);
	return result;
	function move(n, from, to) {
		if (n === 1) {
			result.push([from, to]);
			return;
		}
		move(n - 1, from, 6 - from - to);
		move(1, from, to);
		move(n - 1, 6 - from - to, to);
	}
}
