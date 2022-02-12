import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };
	public static int N, M;
	public static boolean[][] map;
	public static boolean[][] isVisit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new boolean[N][M];
		isVisit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = input[j].equals("1") ? true : false;
			}
		}
		bfs(0, 0);
	}

	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { x, y, 1 });
		while (!q.isEmpty()) {
			int[] poll = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = poll[0] + dx[i];
				int ny = poll[1] + dy[i];
				int cnt = poll[2];
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && !isVisit[nx][ny] && map[nx][ny]) {
					if (nx == N -1&& ny == M-1) {
						System.out.println(cnt+1);
						return;
					}
					isVisit[nx][ny]=true;
					q.offer(new int[] { nx, ny, cnt + 1 });
				}
			}
		}
	}
}
