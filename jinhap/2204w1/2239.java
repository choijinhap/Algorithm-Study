import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}
}

public class Main_2239 {
	static List<Point> list;
	static int[][] map;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		list = new ArrayList<Point>();
		for (int i = 0; i < 9; i++) {
			String str = br.readLine();
			for (int j = 0; j < 9; j++) {
				map[i][j] = str.charAt(j) - '0';
				if (map[i][j] == 0)
					list.add(new Point(i, j));
			}
		}
		dfs(0);
	}

	static void dfs(int level) {
		if (flag)
			return;
		if (level == list.size()) {
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			flag = true;
			return;
		}
		Point poll = list.get(level);
		for (int i = 1; i <= 9; i++) {
			if (check(poll.x, poll.y, i)) {
				map[poll.x][poll.y] = i;
				dfs(level + 1);
				map[poll.x][poll.y] = 0;
			}
		}
	}

	static boolean check(int x, int y, int val) {
		for (int i = 0; i < 9; i++) {
			if (y != i && val == map[x][i]) {
				return false;
			}
			if (x != i && val == map[i][y]) {
				return false;
			}
		}
		for (int i = (x / 3) * 3; i < (x / 3) * 3 + 3; i++) {
			for (int j = (y / 3) * 3; j < (y / 3) * 3 + 3; j++) {
				if (x != i && y != j && val == map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
