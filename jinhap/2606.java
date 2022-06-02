import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static boolean arr[][];
	public static int answer;
	public static boolean isVist[];
	public static int N;
	public static Queue<Integer> queue = new LinkedList<Integer>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new boolean[N + 1][N + 1];
		isVist = new boolean[N + 1];
		answer = 0;
		int lineNum = Integer.parseInt(br.readLine());
		for (int i = 0; i < lineNum; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = arr[y][x] = true;
		}
//		dfs(1);
		bfs();
		System.out.println(answer);
	}

	public static void dfs(int curPoint) {
		for (int i = 1; i < N + 1; i++) {
			if (arr[curPoint][i] && !isVist[i]) {
				answer++;
				isVist[curPoint] = true;
				dfs(i);
			}
		}
	}

	public static void bfs() {
		queue.offer(1);
		isVist[1] = true;
		while (!queue.isEmpty()) {
			int idx = queue.poll();
			for (int i = 1; i < N + 1; i++) {
				if (arr[idx][i] && !isVist[i]) {
					answer++;
					queue.offer(i);
					isVist[i] = true;
				}
			}
		}
	}
}
