/**
 * dp
 */
function solution(n) {
	if (n % 2 !== 0) return 0;
	const dp = Array.from({ length: n / 2 }, () => 0);
	dp[0] = 0;
	dp[1] = 3;
	for (let i = 2; i <= n / 2; i++) {
		dp[i] = 3 * dp[i - 1];
		for (let j = 2; i - j > 0; j++) {
			dp[i] += 2 * dp[i - j];
		}
		dp[i] += 2;
		dp[i] %= 1000000007;
	}
	return dp[n / 2];
}
