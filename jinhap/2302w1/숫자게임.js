function solution(A, B) {
	let answer = 0;
	A = A.sort((a, b) => a - b);
	B = B.sort((a, b) => a - b);
	let min = 0;
	B.forEach((v) => {
		if (v > A[min]) {
			answer++;
			min++;
		}
	});

	return answer;
}
