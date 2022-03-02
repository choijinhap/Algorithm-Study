import java.util.Scanner;

public class Main_1956 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		int[][] map = new int[V + 1][V + 1];
		final int INF = Integer.MAX_VALUE / 2;
		for (int i = 1; i <= V; i++) {
			for (int j = 0; j <= V; j++) {
				if (i != j)
					map[i][j] = INF;
			}
		}
		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int weight = sc.nextInt();
			map[from][to] = weight;
		}
		int ans = INF;
		for (int k = 1; k <= V; k++) {
			for (int i = 1; i <= V; i++) {
				for (int j = 1; j <= V; j++) {
					if (i == j)
						continue;
					if (map[i][j] > map[i][k] + map[k][j])
						map[i][j] = map[i][k] + map[k][j];
				}
			}
		}
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				if (i == j)
					continue;
				if (map[i][j] != INF && map[j][i] != INF)
					ans = Math.min(ans, map[i][j] + map[j][i]);
			}
		}
		ans = ans == INF ? -1 : ans;
		System.out.println(ans);
	}
}
