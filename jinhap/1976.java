import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int a = Integer.parseInt(st.nextToken());
				if (a == 1)
					union(i, j);
			}
		}
		st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		int parent = find(num);
		for (int i = 1; i < M; i++) {
			num = Integer.parseInt(st.nextToken());
			if (parent != find(num)) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
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
}
