import java.util.ArrayList;
import java.util.Scanner;

public class Main_1929 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		int[] dp = new int[M + 1];
		for (int i = 2; i <= M; i++) {
			if (dp[i] == 1) {
				if (i >= N)
					sb.append(dp[i]).append("\n");
			}
			if (dp[i] == 0) {
				dp[i] = 1;
				if (i >= N)
					sb.append(i).append("\n");
				for (int j = 2; j * i <= M; j++) {
					dp[j * i] = -1;
				}
			}
		}
		System.out.println(sb);
	}
}
