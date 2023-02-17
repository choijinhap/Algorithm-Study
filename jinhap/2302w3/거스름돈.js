function solution(n, money) {
	const dp = Array.from({ length: n + 1 }, () => 0);
	dp[0] = 1;

	//처음에 이 포문 순서를 바꿔서 했었다..
	for (let j = 0; j < money.length; j++) {
		for (let i = 0; i <= n; i++) {
			if (i - money[j] >= 0) {
				dp[i] = (dp[i] + dp[i - money[j]]) % 1000000007;
			}
		}
	}
	return dp[n];
}
