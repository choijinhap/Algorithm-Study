function solution(arrayA, arrayB) {
	const a = getMaxNum(arrayA, arrayB);
	const b = getMaxNum(arrayB, arrayA);
	return Math.max(a, b);
}

function getMaxNum(arrayA, arrayB) {
	let gcd = 0;
	arrayA.forEach((num) => (gcd = getGcd(gcd, num)));
	if (arrayB.some((num) => num % gcd === 0)) return 0;
	return gcd;
}

function getGcd(a, b) {
	return a % b === 0 ? b : getGcd(b, a % b);
}
