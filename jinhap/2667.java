import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };
	public static int N;
	public static boolean[][] arr;
	public static boolean[][] isVisit;
	public static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new boolean[N][N];
		isVisit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = s.split("")[j].equals("1") ? true : false;
			}
		}
		List<Integer> answer = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {

			for (int j = 0; j < N; j++) {
				if (arr[i][j] && !isVisit[i][j]) {
					cnt = 1;
//					dfs(i, j);
					bfs(i, j);
					answer.add(cnt);
				}
			}
		}
		answer.sort((a, b) -> a - b);
		System.out.println(answer.size());
		for (int i : answer)
			System.out.println(i);
	}

	public static void dfs(int x, int y) {
		isVisit[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < N && ny >= 0 && ny < N && !isVisit[nx][ny] && arr[nx][ny]) {
				dfs(nx, ny);
				cnt++;
			}
		}
	}

	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { x, y });
		isVisit[x][y] = true;
		while (!q.isEmpty()) {
			int[] poll = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = poll[0] + dx[i];
				int ny = poll[1] + dy[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && !isVisit[nx][ny] && arr[nx][ny]) {
					q.offer(new int[] { nx, ny });
					cnt++;
					isVisit[nx][ny] = true;
				}
			}
		}
	}

}
