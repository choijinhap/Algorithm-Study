function solution(sequence) {
	const seq1 = sequence.map((v, i) => (v *= i % 2 === 0 ? 1 : -1));
	const seq2 = sequence.map((v, i) => (v *= i % 2 !== 0 ? 1 : -1));
	let max = 0;
	let sum1 = 0;
	let sum2 = 0;
	for (let i = 0; i < seq1.length; i++) {
		sum1 += seq1[i];
		if (sum1 < 0) {
			sum1 = 0;
		}
		if (sum1 > max) {
			max = sum1;
		}
	}
	for (let i = 0; i < seq2.length; i++) {
		sum2 += seq2[i];
		if (sum2 < 0) {
			sum2 = 0;
		}
		if (sum2 > max) {
			max = sum2;
		}
	}
	return max;
}
