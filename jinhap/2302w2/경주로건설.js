function solution(board) {
	const N = board.length;
	const moves = [
		[1, 0],
		[-1, 0],
		[0, -1],
		[0, 1],
	];
	const dp = Array.from({ length: N }, () =>
		Array.from({ length: N }, () => Array.from({ length: 4 }, () => Infinity))
	);

	const isValid = (x, y) => x >= 0 && x < N && y >= 0 && y < N && board[x][y] !== 1;
	const queue = [
		[0, 0, 0, 0],
		[0, 0, 0, 3],
	];

	while (queue.length) {
		const [x, y, cost, dir] = queue.shift();
		for (let i = 0; i < moves.length; i++) {
			const [mx, my] = moves[i];
			const [nx, ny] = [x + mx, y + my];
			if (isValid(nx, ny)) {
				let new_cost = cost + 100;
				if (dir !== i) new_cost += 500;
				if (new_cost < dp[nx][ny][i]) {
					dp[nx][ny][i] = new_cost;
					queue.push([nx, ny, new_cost, i]);
				}
			}
		}
	}
	return Math.min(...dp[N - 1][N - 1]);
}
