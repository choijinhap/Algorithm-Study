function solution(n, s) {
	const answer = [];
	if (s / n < 1) return [-1];
	let rest = s;
	for (let i = 0; i < n; i++) {
		const a = (s / n) >> 0;
		answer.push(a);
		rest -= a;
	}
	for (let i = 0; i < rest; i++) {
		answer[answer.length - i - 1]++;
	}
	return answer;
}
