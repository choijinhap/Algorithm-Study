import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5557 {
	static int N;
	static int[] arr;
	static long[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N ];
		for (int i = 0; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dp = new long[21][100];
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 100; j++) {
				dp[i][j] = -1;
			}
		}
		System.out.println(recursion(arr[0], 0));
	}

	static long recursion(int sum, int idx) {
		if (sum < 0 || sum > 20)
			return 0;

		if (idx == N - 2) {
			return (sum == arr[N - 1]) ? 1 : 0;
		}

		if (dp[sum][idx] != -1) {
			return dp[sum][idx];
		}

		dp[sum][idx] = 0;
		return dp[sum][idx] += recursion(sum + arr[idx + 1], idx + 1) + recursion(sum - arr[idx + 1], idx + 1);
	}
}

/*
 * 8 11 13 17 9 8 12 4 5 7 11 3 3 7
 */
