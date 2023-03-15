function solution(maps) {
	const [startPos, leverPos, endPos] = findPositions(maps);
	const findLeverCost = find(startPos, leverPos, maps);
	const findEndCost = find(leverPos, endPos, maps);
	if (findLeverCost === -1) return -1;
	if (findEndCost === -1) return -1;
	return findLeverCost + findEndCost;
}
function find(startPos, endPos, maps) {
	const dir = [
		[1, 0],
		[-1, 0],
		[0, 1],
		[0, -1],
	];
	const queue = [[...startPos, 0]];
	const visited = Array.from({ length: maps.length }, () =>
		Array.from({ legnth: maps[0].length }, () => false)
	);
	visited[startPos[0]][startPos[1]] = true;
	while (queue.length) {
		const [x, y, cost] = queue.shift();
		if (x === endPos[0] && y === endPos[1]) return cost;

		for (let i = 0; i < dir.length; i++) {
			const nx = x + dir[i][0];
			const ny = y + dir[i][1];
			if (isAvailable(nx, ny, maps, visited)) {
				queue.push([nx, ny, cost + 1]);
				visited[nx][ny] = true;
			}
		}
	}
	return -1;
}

function isAvailable(x, y, maps, visited) {
	if (x < 0 || y < 0 || x >= maps.length || y >= maps[0].length) return false;
	if (visited[x][y]) return false;
	if (maps[x][y] === 'X') return false;
	return true;
}

function findPositions(maps) {
	let startPos;
	let leverPos;
	let endPos;
	for (let i = 0; i < maps.length; i++) {
		for (let j = 0; j < maps[i].length; j++) {
			if (maps[i][j] === 'S') {
				startPos = [i, j];
			}
			if (maps[i][j] === 'L') {
				leverPos = [i, j];
			}
			if (maps[i][j] === 'E') {
				endPos = [i, j];
			}
		}
	}
	return [startPos, leverPos, endPos];
}
