import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16940 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] edgeList = new ArrayList[N];
		int[] arr = new int[N];
		int[] order = new int[N];
		boolean[] visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			edgeList[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken())-1;
			edgeList[from].add(to);
			edgeList[to].add(from);
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken()) - 1;
			order[arr[i]] = i;
		}

		for (int i = 0; i < N; i++) {
			Collections.sort(edgeList[i], new Comparator<Integer>() {
				public int compare(Integer from, Integer to) {
					if (order[from] < order[to]) {
						return -1;
					} else if (order[from] == order[to]) {
						return 0;
					} else {
						return 1;
					}
				}
			});
		}

		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(0);
		visited[0] = true;
		ArrayList<Integer> bfsOrder = new ArrayList<Integer>();
		while (!q.isEmpty()) {
			int poll = q.poll();
			bfsOrder.add(poll);
			for (int e : edgeList[poll]) {
				if (!visited[e]) {
					visited[e] = true;
					q.offer(e);
				}
			}
		}

		boolean flag = true;
		for (int i = 0; i < N; i++) {
			if (bfsOrder.get(i) != arr[i]) {
				flag = false;
				break;
			}
		}
		if (flag)
			System.out.println(1);
		else
			System.out.println(0);
	}

}
