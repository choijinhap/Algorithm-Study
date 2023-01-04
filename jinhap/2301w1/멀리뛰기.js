function solution(n) {
	let dp = [0, 1, 2];
	for (let i = 2; i <= n; i++) {
		dp.push((dp[i] + dp[i - 1]) % 1234567);
	}
	return dp[n];
}
