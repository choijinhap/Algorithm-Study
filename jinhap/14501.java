import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14501 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] T = new int[N + 1];
		int[] P = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		int answer = solve(N, T, P);
		System.out.println(answer);
	}

	static int solve(int N, int[] T, int[] P) {
		int answer = 0;
		int[] dp = new int[N + 2];
		for (int i = 1; i < N + 1; i++) {
			if (dp[i] < dp[i - 1])
				dp[i] = dp[i - 1];
			if (i + T[i] < N + 2) {
				dp[i + T[i]] = Math.max(dp[i] + P[i], dp[i + T[i]]);
				if (answer < dp[i + T[i]])
					answer = dp[i + T[i]];
			}
		}
		return answer;
	}
}
