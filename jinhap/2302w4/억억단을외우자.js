function solution(e, starts) {
	const arr = Array.from({ length: e + 1 }, () => 0);
	for (let i = 1; i <= e; i++) {
		for (let j = i; j <= e; j += i) {
			arr[j] += 1;
		}
	}

	const dp = Array.from({ length: e + 1 }, (a, b) => b);
	for (let i = e - 1; i >= 1; i--) {
		if (arr[i] >= arr[dp[i + 1]]) {
			dp[i] = i;
		} else {
			dp[i] = dp[i + 1];
		}
	}
	return starts.map((s) => dp[s]);
}
