import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2294 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] dp = new int[k + 1];
		for (int i = 0; i < k + 1; i++) {
			dp[i] = Integer.MAX_VALUE/2;
		}

		int[] coins = new int[n];
		for (int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
			if (coins[i] < k + 1)
				dp[coins[i]] = 1;
		}
		Arrays.sort(coins);

		for (int i = 0; i < k + 1; i++) {
			for (int j = 0; j < n; j++) {
				if (i - coins[j] >= 0) {
					dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
				}
			}
		}
		if (dp[k] != Integer.MAX_VALUE/2)
			System.out.println(dp[k]);
		else
			System.out.println(-1);
	}

}
