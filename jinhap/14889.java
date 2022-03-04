import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14889 {
	static int N;
	static int[][] arr;
	static int ans;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		visited = new boolean[N];
		ans = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solve(0, 0);
		System.out.println(ans);
	}

	public static void solve(int cnt, int level) {
		if (level == N )
			return;
		if (cnt == N / 2) {
			int sum1 = 0;
			int sum2 = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i] == visited[j]&& visited[j]== true)
						sum1 += arr[i][j];
					else if (visited[i] == visited[j]&&visited[j] == false) {
						sum2 += arr[i][j];
					}
				}
			}
			if (Math.abs(sum2 - sum1) < ans)
				ans = Math.abs(sum2 - sum1);
			return;
		}
		solve(cnt, level + 1);
		visited[level] = true;
		solve(cnt + 1, level + 1);
		visited[level] = false;
		return;

	}
}
