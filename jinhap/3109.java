import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int R, C, ans;
	static char map[][];
	static boolean isVisit[][];
	static int[] dx = { -1, 0, 1 };
	static int[] dy = { 1, 1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		isVisit = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			map[i] = st.nextToken().toCharArray();
		}
		ans = 0;
		for (int i = 0; i < R; i++) {
			solve(i, 0);
		}
		System.out.println(ans);
	}

	public static boolean solve(int row, int col) {
		map[row][col] = 'X';
		if (col == C - 1) {
			ans++;
			return true;
		}
		for (int i = 0; i < 3; i++) {
			int nx = row + dx[i];
			int ny = col + dy[i];
			if (nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] == '.') {
				if (solve(nx, ny))
					return true;
			}
		}
		return false;

	}
}
