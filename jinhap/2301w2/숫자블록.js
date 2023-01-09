function solution(begin, end) {
	let answer = [];
	for (let i = begin; i <= end; i++) {
		answer.push(getMaxDivisor(i));
	}
	return answer;
}

function getMaxDivisor(n) {
	if (n === 1) return 0;
	for (let i = 2; i <= Math.sqrt(n); i++) {
		if (n % i === 0 && n / i <= 1e7) return n / i;
	}
	return 1;
}
