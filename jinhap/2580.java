import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Point {
	int x;
	int y;
	int val;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
		this.val = 0;
	}
}

public class Main {
	public static final int N = 9;
	public static int[][] map = new int[N][N];
	public static List<Point> list = new ArrayList<Point>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0)
					list.add(new Point(i, j));
			}
		}
		solve(0);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		sb.setLength(sb.length() - 1);
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}

	public static boolean solve(int idx) {
		if (idx == list.size()) {
			return true;
		}
		Point p = list.get(idx);
		for (int val = 1; val <= 9; val++) {
			if (check(p.x, p.y, val)) {
				map[p.x][p.y] = val;
				if (solve(idx + 1))
					return true;
				map[p.x][p.y] =0;

			}
		}

		return false;
	}

	public static boolean check(int x, int y, int val) {
		for (int i = 0; i < N; i++) {
			if (i != x && map[i][y] == val)
				return false;
			if (i != y && map[x][i] == val)
				return false;
		}
		int startX = x - x % 3;
		int startY = y - y % 3;
		for (int i = startX; i < startX + 3; i++) {
			for (int j = startY; j < startY + 3; j++) {
				if(i==x&&j==y) continue;
				if ( map[i][j] == val)
					return false;
			}
		}
		return true;
	}
}
