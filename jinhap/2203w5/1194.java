import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1194 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		Traveler traveler = null;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == '0')
					traveler = new Traveler(i, j, 0, 0);
			}
		}

		boolean[][][] visited = new boolean[N][M][64];
		Queue<Traveler> q = new LinkedList<Traveler>();
		q.add(traveler);
		visited[traveler.x][traveler.y][traveler.keys] = true;
		int answer = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			Traveler poll = q.poll();
			if (map[poll.x][poll.y] == '1')
				answer = Math.min(answer, poll.move);
			for (int i = 0; i < 4; i++) {
				int nx = poll.x + dx[i];
				int ny = poll.y + dy[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if (!visited[nx][ny][poll.keys]) {
						if (map[nx][ny] == '0' || map[nx][ny] == '.' || map[nx][ny] == '1') {
							q.add(new Traveler(nx, ny, poll.move + 1, poll.keys));
							visited[nx][ny][poll.keys] = true;
						}
						// 키
						else if (map[nx][ny] >= 'a' && map[nx][ny] <= 'f') {
							q.add(new Traveler(nx, ny, poll.move + 1, poll.keys | (1 << (map[nx][ny] - 'a'))));
							visited[nx][ny][poll.keys | (1 << (map[nx][ny] - 'a'))] = true;
						} else if (map[nx][ny] >= 'A' && map[nx][ny] <= 'F') {
							if ((poll.keys & (1 << (map[nx][ny] - 'A'))) > 0) {
								q.add(new Traveler(nx, ny, poll.move + 1, poll.keys));
								visited[nx][ny][poll.keys] = true;
							}
						}

					}
				}
			}
		}
		if (answer == Integer.MAX_VALUE)
			answer = -1;
		System.out.println(answer);

	}
}

class Traveler {
	int x;
	int y;
	int move;
	int keys;

	public Traveler(int x, int y, int move, int keys) {
		this.x = x;
		this.y = y;
		this.move = move;
		this.keys = keys;
	}

}
