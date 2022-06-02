import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_12026 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		char[] arr = str.toCharArray();

		int[] dp = new int[N];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		dp[0] = 0;
		for (int i = 0; i < N; i++) {
			char cur = arr[i];
			char nextChar = getNextChar(cur);
			for (int j = i + 1; j < N; j++) {
				if (arr[j] == nextChar && dp[i] != Integer.MAX_VALUE) {
					dp[j] = Math.min(dp[j], dp[i] + (j - i) * (j - i));
				}
			}
		}
		if (dp[N - 1] == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(dp[N - 1]);
	}

	static char getNextChar(char c) {
		if (c == 'B')
			return 'O';
		else if (c == 'O')
			return 'J';
		else
			return 'B';
	}
}
