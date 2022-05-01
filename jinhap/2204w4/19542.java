import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_19542 {
	static int N, S, D, dist[];
	static ArrayList<Integer> relation[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		relation = new ArrayList[N + 1];
		dist = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			relation[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			relation[from].add(to);
			relation[to].add(from);
		}
		dfs(S, 0);

		int res = 0;
		for (int i = 1; i <= N; i++) {
			if (i != S && dist[i] >= D) {
				res += 1;
			}
		}
		System.out.println(res*2);
	}

	static int dfs(int node, int cnt) {
		if (node != S && relation[node].size() == 1) {
			return dist[node] = 0;
		}
		for (int i = 0; i < relation[node].size(); i++) {
			int next = relation[node].get(i);
			if (next == cnt)
				continue;
			dist[node] = Math.max(dist[node], dfs(next, node) + 1);
		}
		return dist[node];
	}
}
