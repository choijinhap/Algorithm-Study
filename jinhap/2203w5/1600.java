import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600 {
	static int K, W, H;
	static int[][] map;
	static int[] kdx = { -2, -2, -1, -1, 1, 1, 2, 2 };
	static int[] kdy = { -1, 1, -2, 2, -2, 2, -1, 1 };
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Monkey start = new Monkey(0, 0, K, 0);
		boolean[][][] visited = new boolean[H][W][K+1];
		Queue<Monkey> q = new LinkedList<Monkey>();
		q.add(start);
		visited[start.x][start.y][start.k] = true;
		while (!q.isEmpty()) {
			Monkey poll = q.poll();
			if (poll.x == H - 1 && poll.y == W - 1) {
				System.out.println(poll.cnt);
				return;
			}
			if (poll.k > 0) {
				for (int i = 0; i < 8; i++) {
					int nx = poll.x + kdx[i];
					int ny = poll.y + kdy[i];
					if (nx >= 0 && nx < H && ny >= 0 && ny < W && !visited[nx][ny][poll.k-1] && map[nx][ny] != 1) {
						q.add(new Monkey(nx, ny, poll.k - 1, poll.cnt + 1));
						visited[nx][ny][poll.k-1]=true;
					}
				}
			}
			for (int i = 0; i < 4; i++) {
				int nx = poll.x + dx[i];
				int ny = poll.y + dy[i];
				if (nx >= 0 && nx < H && ny >= 0 && ny < W && !visited[nx][ny][poll.k] && map[nx][ny] != 1) {
					q.add(new Monkey(nx, ny, poll.k, poll.cnt + 1));
					visited[nx][ny][poll.k]=true;
				}
			}
		}
		System.out.println(-1);
	}
}

class Monkey {
	int cnt;
	int x;
	int y;
	int k;

	public Monkey(int x, int y, int k, int cnt) {
		this.x = x;
		this.y = y;
		this.k = k;
		this.cnt = cnt;
	}
}
