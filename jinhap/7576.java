import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };
	public static int M, N;
	public static boolean[][] isVisit;
	public static List<int[]> startPoint = new ArrayList<int[]>();
	public static int[][] map;
	public static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		isVisit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					startPoint.add(new int[] { i, j });
					isVisit[i][j] = true;
				}
				if (map[i][j] == -1)
					isVisit[i][j] = true;
			}
		}

		bfs();
		if (isFill())
			System.out.println(cnt);
		else
			System.out.println(-1);
	}

	public static void bfs() {
		Queue<List<int[]>> q = new LinkedList<List<int[]>>();
		q.offer(startPoint);
		while (!q.isEmpty()) {
			List<int[]> poll = q.poll();
			List<int[]> tmp = new ArrayList<int[]>();
			for (int[] point : poll) {
				for (int i = 0; i < 4; i++) {
					int nx = point[0] + dx[i];
					int ny = point[1] + dy[i];
					if (nx >= 0 && nx < N && ny >= 0 && ny < M && !isVisit[nx][ny] && map[nx][ny] == 0) {
						isVisit[nx][ny] = true;
						tmp.add(new int[] { nx, ny });
					}
				}
			}
			if (tmp.size() > 0) {
				q.offer(tmp);
				cnt++;
			}
		}
	}

	public static boolean isFill() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!isVisit[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
