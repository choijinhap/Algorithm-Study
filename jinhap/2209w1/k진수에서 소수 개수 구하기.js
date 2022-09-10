function solution(n, k) {
	let answer = 0;
	let parsedNum = n.toString(k);
	const list = parsedNum.split('0');
	list.forEach((v) => isPrime(Number(v)) && answer++);

	return answer;
}

function nToK(n, k) {
	let answer = '';
	let num = n;
	while (num >= k) {
		answer = Number.parseInt(num % k) + answer;
		num = Number.parseInt(num / k);
	}
	if (num > 0) answer = num + answer;
	return answer;
}

function isPrime(num) {
	if (num < 2) return false;
	for (let i = 2; i <= Number.parseInt(Math.sqrt(num)); i++) {
		if (num % i === 0) return false;
	}
	return true;
}
