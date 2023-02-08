function solution(n, s, a, b, fares) {
	const adj = Array.from({ length: n + 1 }, () => Array.from({ length: n + 1 }, () => 0));
	const dp = Array.from({ length: n + 1 }, () =>
		Array.from({ length: n + 1 }, () => Number.MAX_SAFE_INTEGER)
	);
	for (let i = 1; i < n + 1; i++) {
		dp[i][i] = 0;
	}
	fares.forEach(([from, to, cost]) => {
		adj[from][to] = cost;
		adj[to][from] = cost;
		dp[from][to] = cost;
		dp[to][from] = cost;
	});

	for (let k = 1; k < n + 1; k++) {
		for (let i = 1; i < n + 1; i++) {
			for (let j = 1; j < n + 1; j++) {
				if (dp[i][j] > dp[i][k] + dp[k][j]) {
					dp[i][j] = dp[i][k] + dp[k][j];
				}
			}
		}
	}
	let min = Number.MAX_SAFE_INTEGER;
	for (let i = 1; i < dp.length; i++) {
		if (dp[s][i] + dp[i][a] + dp[i][b] < min) {
			min = dp[s][i] + dp[i][a] + dp[i][b];
		}
	}

	return min;
}
