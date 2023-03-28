/**
 * dp
 */
function solution(target) {
	const dp = Array.from({ length: 100001 }, () => [Infinity, Infinity]);
	for (let i = 1; i <= 20; i++) {
		dp[i] = [1, 1];
		if (i * 2 < dp.length && dp[i * 2][1] !== 1) dp[i * 2] = [1, 0];
		if (i * 3 < dp.length && dp[i * 3][1] !== 1) dp[i * 3] = [1, 0];
	}
	dp[50] = [1, 1];
	for (let i = 1; i <= target; i++) {
		if (i + 50 < dp.length && dp[i][0] + 1 <= dp[i + 50][0] && dp[i][1] + 1 >= dp[i + 50][1]) {
			dp[i + 50] = [dp[i][0] + 1, dp[i][1] + 1];
		}

		for (let j = 1; j <= 20; j++) {
			if (i + j < dp.length && dp[i][0] + 1 <= dp[i + j][0] && dp[i][1] + 1 >= dp[i + j][1]) {
				dp[i + j] = [dp[i][0] + 1, dp[i][1] + 1];
			}

			if (i + 2 * j < dp.length && dp[i][0] + 1 < dp[i + 2 * j][0]) {
				dp[i + 2 * j] = [dp[i][0] + 1, dp[i][1]];
			}

			if (i + 3 * j < dp.length && dp[i][0] + 1 < dp[i + 3 * j][0]) {
				dp[i + 3 * j] = [dp[i][0] + 1, dp[i][1]];
			}
		}
	}
	return dp[target];
}
