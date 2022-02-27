import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1504 {
	static int N;
	static int[][] map;
	static final int INF= 200000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			map[a][b] = map[b][a] = weight;
		}
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());

		// 1 -> v1 -> v2 -> N
		// 1 -> v2 -> v1 -> N
		// 1 v1 과 1 v2중에 짧은거 고른다음 결정하면 될듯
		int ans = Math.min(getShortDis(1, v1) + getShortDis(v1, v2) + getShortDis(v2, N),
				getShortDis(1, v2) + getShortDis(v2, v1) + getShortDis(v1, N));
		if (ans >= INF)
			ans = -1;
		System.out.println(ans);
	}

	public static int getShortDis(int from, int to) {
		int[] distance = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);

		distance[from] = 0;

		for (int i = 0; i < N; i++) {
			int min = Integer.MAX_VALUE;
			int cur = 0;
			for (int j = 1; j <= N; j++) {
				if (!visited[j] && min > distance[j]) {
					min = distance[j];
					cur = j;
				}
			}
			visited[cur] = true;

			for (int j = 1; j <= N; j++) {
				if (!visited[j] && map[cur][j] != 0 && distance[j] > distance[cur] + map[cur][j]) {
					distance[j] = distance[cur] + map[cur][j];
				}
			}
		}
		return distance[to];
	}
}
