import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		parents = new int[N + 1];
		for (int i = 1; i <= N; i++)
			parents[i] = i;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (op == 0) {
				union(a, b);
			} else {
				System.out.println(check(a, b));
			}
		}
	}

	public static int find(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = find(parents[a]);
	}

	public static boolean union(int a, int b) {
		int aRep = find(a);
		int bRep = find(b);
		if (aRep == bRep)
			return false;
		parents[aRep] = bRep;
		return true;
	}

	public static String check(int a, int b) {
		return find(a) == find(b) ? "YES" : "NO";
	}
}
