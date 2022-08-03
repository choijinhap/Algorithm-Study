function solution(grid) {
	let answer = [];
	const dx = [-1, 1, 0, 0];
	const dy = [0, 0, -1, 1];
	const visited = grid.map((a) => a.split('').map((b) => [0, 0, 0, 0]));

	for (let x = 0; x < grid.length; x++) {
		for (let y = 0; y < grid[0].length; y++) {
			for (let d = 0; d < dx.length; d++) {
				if (visited[x][y][d]) continue;
				const cnt = check(x, y, d);
				if (cnt) answer.push(cnt);
			}
		}
	}
	return answer.sort((a, b) => a - b);

	function check(x, y, d) {
		let cnt = 0;
		while (true) {
			if (visited[x][y][d]) break;
			visited[x][y][d] = 1;
			cnt++;

			x += dx[d];
			y += dy[d];
			if (x < 0) x = grid.length - 1;
			if (x >= grid.length) x = 0;
			if (y < 0) y = grid[0].length - 1;
			if (y >= grid[0].length) y = 0;
			d = getDir(grid[x][y], d);
		}
		return cnt;
	}

	function getDir(block, dir) {
		if (block === 'S') return dir;
		if (block === 'L') return [2, 3, 1, 0][dir];
		if (block === 'R') return [3, 2, 0, 1][dir];
	}
}
