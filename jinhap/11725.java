import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11725 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] edge = new int[N - 1][2];
		ArrayList<Integer>[] list = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
//		for (int i = 0; i < N - 1; i++) {
//			st = new StringTokenizer(br.readLine());
//			for (int j = 0; j < 2; j++) {
//				edge[i][j] = Integer.parseInt(st.nextToken());
//			}
//		}
//		solve(N, edge);
//		System.out.println(N);
		solve(N, list);
	}

	static void solve(int N, ArrayList<Integer>[] list) {
		boolean[] visited = new boolean[N + 1];
		int[] parents = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			if (!visited[i])
				dfs(i, parents, visited, list);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i < N + 1; i++) {
			sb.append(parents[i] + "\n");
		}
		System.out.println(sb);
	}

	static void dfs(int i, int[] parents, boolean[] visited, ArrayList<Integer>[] list) {
		if (visited[i])
			return;
		visited[i] = true;
		for (int point : list[i]) {
			if (!visited[point]) {
				parents[point] = i;
				dfs(point, parents, visited, list);
			}
		}
	}

	static void solve2(int N, int[][] edge) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[N + 1];
		int[] parents = new int[N + 1];
		q.add(1);
		visited[1] = true;
		while (!q.isEmpty()) {
			int parentIdx = q.poll();
			for (int i = 0; i < N - 1; i++) {
				if (edge[i][0] == parentIdx && !visited[edge[i][1]]) {
					q.add(edge[i][1]);
					parents[edge[i][1]] = parentIdx;
					visited[edge[i][1]] = true;
				} else if (edge[i][1] == parentIdx && !visited[edge[i][0]]) {
					q.add(edge[i][0]);
					parents[edge[i][0]] = parentIdx;
					visited[edge[i][0]] = true;
				}
			}

		}
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i < N + 1; i++) {
			sb.append(parents[i] + "\n");
		}
		System.out.println(sb);
	}
}
