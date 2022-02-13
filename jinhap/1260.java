import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static StringBuilder sb;
	public static int N;
	public static boolean[][] graph;
	public static boolean[] isVisit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int lineNum = Integer.parseInt(st.nextToken());
		int startIndex = Integer.parseInt(st.nextToken());
		graph = new boolean[N + 1][N + 1];
		for (int i = 0; i < lineNum; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = graph[b][a] = true;
		}
		isVisit = new boolean[N + 1];
		sb = new StringBuilder();
		DFS(startIndex);
		System.out.println(sb);
		isVisit = new boolean[N + 1];
		sb = new StringBuilder();
		BFS(startIndex);
		System.out.println(sb);

	}

	public static void DFS(int beforePoint) {
		isVisit[beforePoint] = true;
		sb.append(beforePoint).append(" ");
		for (int i = 1; i < N + 1; i++) {
			if (graph[beforePoint][i] && !isVisit[i]) {
				DFS(i);
			}
		}
	}

	public static void BFS(int startPoint) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(startPoint);
		isVisit[startPoint] = true;
		sb.append(startPoint).append(" ");
		while (!queue.isEmpty()) {
			int curPoint = queue.poll();
			for (int i = 1; i < N + 1; i++) {
				if (graph[curPoint][i] && !isVisit[i]) {
					queue.offer(i);
					isVisit[i] = true;
					sb.append(i).append(" ");
				}
			}
		}
	}
}
