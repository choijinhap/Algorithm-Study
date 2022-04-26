import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2629 {
	static boolean[][] dp;
	static int N;
	static int[] weights;
	static int M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		weights = new int[N + 1];
		dp = new boolean[31][15001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			weights[i] = Integer.parseInt(st.nextToken());
		}
		find(0, 0);
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int num = (Integer.parseInt(st.nextToken()));
			if (num > 15000)
				System.out.print("N ");
			else {
				if (dp[N][num])
					System.out.print("Y ");
				else
					System.out.print("N ");
			}
		}
	}

	static void find(int idx, int weight) {
		if (dp[idx][weight])
			return;
		dp[idx][weight] = true;
		if (idx == N)
			return;

		find(idx + 1, weight + weights[idx + 1]);
		find(idx + 1, weight);
		find(idx + 1, Math.abs(weight - weights[idx + 1]));
	}
}
