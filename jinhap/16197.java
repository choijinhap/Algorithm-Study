import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16197 {
	static char[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N;
	static int M;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		int[][] coins = new int[2][2];
		int a = 0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'o') {
					coins[a][0] = i;
					coins[a][1] = j;
					a++;
				}
			}
		}
		go(coins, 1);
		if (answer == Integer.MAX_VALUE)
			answer = -1;
		System.out.println(answer);
	}

	static void go(int[][] coins, int cnt) {
		if (cnt > 10) {
			return;
		}
		for (int i = 0; i < 4; i++) {
			int outCnt = 0;
			int nx1 = coins[0][0] + dx[i];
			int ny1 = coins[0][1] + dy[i];
			int nx2 = coins[1][0] + dx[i];
			int ny2 = coins[1][1] + dy[i];

			// 조건
			// 둘중 하나만 밖으로 나가면 갯수 비교
			// 둘다나가면 x
			if (nx1 < 0 || nx1 >= N || ny1 < 0 || ny1 >= M) {
				outCnt++;
			}
			if (nx2 < 0 || nx2 >= N || ny2 < 0 || ny2 >= M) {
				outCnt++;
			}
			if (outCnt == 1) {
				answer = Math.min(cnt, answer);
				continue;
			}
			if (outCnt == 2) {
				continue;
			}
			if (outCnt == 0) {
				if (map[nx1][ny1] == '#') {
					nx1 -= dx[i];
					ny1 -= dy[i];
				}
				if (map[nx2][ny2] == '#') {
					nx2 -= dx[i];
					ny2 -= dy[i];
				}
				int[][] newCoins = { { nx1, ny1 }, { nx2, ny2 } };
				go(newCoins, cnt + 1);
			}
		}
	}
}
