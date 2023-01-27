/*
* 단순하게 모든 연산 수행하면 시간초과..
*
*
function solution(board, skill) {
	var answer = 0;
	skill.forEach(([type, r1, c1, r2, c2, degree]) => {
		for (let i = r1; i <= r2; i++) {
			for (let j = c1; j <= c2; j++) {
				type === 1 ? (board[i][j] -= degree) : (board[i][j] += degree);
			}
		}
	});
	for (let i = 0; i < board.length; i++) {
		for (let j = 0; j < board[i].length; j++) {
			if (board[i][j] > 0) answer++;
		}
	}
	return answer;
}
*/

/**
 * 누적합 알고리즘 imos 적용
 * https://nicotina04.tistory.com/163
 */
function solution(board, skill) {
	let answer = 0;
	const imos = Array.from({ length: board.length + 1 }, () =>
		Array.from({ length: board[0].length + 1 }, () => 0)
	);

	skill.forEach(([type, r1, c1, r2, c2, degree]) => {
		imos[r1][c1] += type === 1 ? -degree : degree;
		imos[r1][c2 + 1] += type === 1 ? degree : -degree;
		imos[r2 + 1][c1] += type === 1 ? degree : -degree;
		imos[r2 + 1][c2 + 1] += type === 1 ? -degree : degree;
	});

	for (let i = 0; i < imos.length; i++) {
		let sum = 0;
		for (let j = 0; j < imos[0].length; j++) {
			sum += imos[i][j];
			imos[i][j] = sum;
		}
	}
	for (let i = 0; i < imos[0].length; i++) {
		let sum = 0;
		for (let j = 0; j < imos.length; j++) {
			sum += imos[j][i];
			imos[j][i] = sum;
		}
	}
	for (let i = 0; i < board.length; i++) {
		for (let j = 0; j < board[i].length; j++) {
			if (board[i][j] + imos[i][j] > 0) answer++;
		}
	}
	return answer;
}
