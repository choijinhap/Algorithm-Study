function solution(n, results) {
	const adj = Array.from({ length: n + 1 }, () => Array.from({ length: n + 1 }, () => 0));
	const visited = Array.from({ length: n + 1 }, () => Array.from({ length: n + 1 }, () => false));

	results.forEach(([from, to]) => {
		adj[from][to] = 1;
		adj[to][from] = -1;
	});

	for (let i = 1; i <= n; i++) {
		dfs(i, i);
	}

	for (let i = 1; i <= n; i++) {
		let cnt = 0;
		for (let j = 1; j <= n; j++) {
			if (adj[i][j] != 0) cnt++;
		}
		if (cnt === n - 1) answer++;
	}

	function dfs(parent, num) {
		for (let i = 1; i <= n; i++) {
			if (adj[num][i] === 1 && !visited[parent][i]) {
				visited[parent][i] = true;
				adj[parent][i] = 1;
				adj[i][parent] = -1;
				dfs(parent, i);
			}
		}
	}

	return answer;
}
