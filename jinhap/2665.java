import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//1시간 초과 해답찬스

public class Main_2665 {
	static int N;
	static int[][] map;
	static int[][] ans;
	static int[] dx = new int[] { -1, 1, 0, 0 };
	static int[] dy = new int[] { 0, 0, -1, 1 };
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		ans = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0';
				ans[i][j] = Integer.MAX_VALUE;
			}
		}
//		int x = 0;
//		int y = 0;
//		ans[x][y] = (map[x][y] == 1 ? 0 : 1);
//		visited[x][y] = true;
//		solve(x, y);
		System.out.println(bfs());

	}

	public static void solve(int x, int y) {

		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
				ans[nx][ny] = Math.min(ans[nx][ny], ans[x][y] + (map[nx][ny] == 1 ? 0 : 1));
				if (!visited[nx][ny])
					solve(nx, ny);
			}

		}
	}

	public static int bfs() {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(0, 0));
		ans[0][0] = (map[0][0] == 1 ? 0 : 1);
		while (!q.isEmpty()) {
			Point poll = q.poll();
			int x = poll.x;
			int y = poll.y;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && ans[nx][ny] > ans[x][y]) {
					if (map[nx][ny] == 1) {
						ans[nx][ny] = ans[x][y];
					} else {
						ans[nx][ny] = ans[x][y] + 1;
					}
					q.add(new Point(nx, ny));
				}
			}
		}
		return ans[N - 1][N - 1];
	}

	/*
	 * 다익스트라 알고리즘 출발 노드를 설정 출발노드를 기준으로 각노드의 최소비용저장 방문하지 않은 노드중에서 가장 비용이 적은 노드 선택 해당
	 * 노드를 거쳐 특정한 노드로 가는경우를 고려하여 최소 비용갱신 위과정반복
	 */
}

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
