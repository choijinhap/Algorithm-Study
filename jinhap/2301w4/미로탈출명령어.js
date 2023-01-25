function solution(n, m, x, y, r, c, k) {
	var answer = '';
	if (!check(x, y, r, c, k)) return 'impossible';
	const xLen = Math.abs(r - x);
	const yLen = Math.abs(c - y);
	let remain = k - (xLen + yLen);
	for (let i = 0; i < k; i++) {
		if (x < r) {
			answer += 'd';
			x++;
			continue;
		}
		if (remain && x + 1 <= n) {
			answer += 'd';
			x++;
			remain -= 2;
			continue;
		}
		if (y > c) {
			answer += 'l';
			y--;
			continue;
		}
		if (remain && y - 1 >= 1) {
			answer += 'l';
			y--;
			remain -= 2;
			continue;
		}
		if (y < c) {
			answer += 'r';
			y++;
			continue;
		}
		if (remain && y + 1 <= m) {
			answer += 'r';
			y++;
			remain -= 2;
			continue;
		}
		if (x > r) {
			answer += 'u';
			x--;
			continue;
		}
		if (remain && x - 1 >= 1) {
			answer += 'u';
			x--;
			remain -= 2;
			continue;
		}
	}
	return answer;
}
function check(x, y, r, c, k) {
	const xLen = Math.abs(r - x);
	const yLen = Math.abs(c - y);
	if (xLen + yLen > k || (k - xLen - yLen) % 2 === 1) return false;
	return true;
}
