function solution(n, a, b) {
	let answer = 1;
	if (a > b) {
		let tmp = a;
		a = b;
		b = tmp;
	}
	while (n > 1) {
		if (a % 2 === 1 && b === a + 1) {
			return answer;
		} else {
			answer++;
			a = Math.round(a / 2);
			b = Math.round(b / 2);
		}
	}
	return answer;
}
