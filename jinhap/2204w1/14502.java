import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502 {
	static int N, M;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int answer = 0;
	static int wallCnt = 3;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					wallCnt++;
			}
		}
		dfs(0);
		System.out.println(answer);
	}

	static void dfs(int cnt) {
		if (cnt == 3) {
			check();
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					dfs(cnt + 1);
					map[i][j] = 0;
				}
			}
		}
	}

	static void check() {
		int[][] newMap = new int[N][M];
		Queue<Integer[]> q = new LinkedList<Integer[]>();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newMap[i][j] = map[i][j];
				if (newMap[i][j] == 2) {
					q.offer(new Integer[] { i, j });
				}
			}
		}
		while (!q.isEmpty()) {
			Integer[] poll = q.poll();
			cnt++;
			for (int d = 0; d < 4; d++) {
				int nx = poll[0] + dx[d];
				int ny = poll[1] + dy[d];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if (newMap[nx][ny] == 0) {
						newMap[nx][ny] = 2;
						q.offer(new Integer[] { nx, ny });
					}
				}
			}
		}
		answer = Math.max(N*M-cnt-wallCnt, answer);
	}
}
