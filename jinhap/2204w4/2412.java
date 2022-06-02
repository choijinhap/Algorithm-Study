import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2412 {
	static int N, T;
	static ArrayList<Integer>[] rock;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		rock = new ArrayList[200001];
		for (int i = 0; i < 200001; i++) {
			rock[i] = new ArrayList<>();
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			rock[y].add(x);
		}
		for (int i = 0; i < 200001; i++) {
			Collections.sort(rock[i]);
		}

		System.out.println(bfs());
	}

	static int bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { 0, 0, 0 });
		int cnt = 0;
		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			if (poll[1] == T)
				return poll[2];
			for (int y = poll[1] - 2; y <= poll[1] + 2; y++) {
				if (y < 0 || y >= 200001)
					continue;
				for (int j = 0; j < rock[y].size(); j++) {
					int x = rock[y].get(j);
					if (poll[0] + 2 < x)
						break;
					else if (poll[0] - 2 > x)
						continue;
					rock[y].remove(j);
					queue.add(new int[] { x, y, poll[2] + 1 });
					j--;
				}
			}
		}
		return -1;
	}
}
