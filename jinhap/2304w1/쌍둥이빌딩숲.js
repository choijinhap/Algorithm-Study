/**
 * dp
 */
function solution(n, count) {
	const dp = Array.from({ length: n + 1 }, () => Array.from({ length: n + 1 }, () => 0));
	for (let i = 1; i <= n; i++) {
		dp[i][i] = 1;
	}
	for (let i = 1; i <= n; i++) {
		for (let j = i - 1; j >= 1; j--) {
			dp[i][j] = (dp[i - 1][j] * (i - 1) * 2 + dp[i - 1][j - 1]) % 1000000007;
		}
	}
	return dp[n][count];
}
