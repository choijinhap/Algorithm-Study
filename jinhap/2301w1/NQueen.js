/**
 * @param {number} n
 * @return {string[][]}
 */
const solveNQueens = function (n) {
	let answer = [];
	for (let i = 0; i < n; i++) {
		const board = new Array(n).fill('');
		board[0] = makeRow(i);
		dfs(board, 0);
	}
	return answer;

	function dfs(board, row) {
		if (row === n - 1) {
			answer.push([...board]);
			return;
		}
		for (let i = 0; i < n; i++) {
			board[row + 1] = makeRow(i);
			if (isValid(board, row + 1, i)) dfs(board, row + 1);
		}
	}

	function isValid(board, row, idx) {
		for (let i = 0; i < row; i++) {
			if (board[i][idx] === 'Q') {
				return false;
			}
			if (Math.abs(board[i].indexOf('Q') - idx) === Math.abs(i - row)) {
				return false;
			}
		}
		return true;
	}
	function makeRow(idx) {
		return '.'.repeat(idx) + 'Q' + '.'.repeat(n - idx - 1);
	}
};
