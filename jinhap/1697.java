import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697 {
	public static int N, X;
	public static int[] isVisit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		isVisit = new int[100001];
		bfs(N);
	}

	public static void bfs(int curPoint) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(curPoint);
		isVisit[curPoint] = 1;
		while (!q.isEmpty()) {
			int nextPoint = q.poll();
			if (nextPoint == X) {
				System.out.println(isVisit[nextPoint]-1);
				return;
			}
			if (nextPoint * 2 <= 100000 && isVisit[nextPoint * 2] == 0) {
				isVisit[nextPoint * 2] = isVisit[nextPoint] + 1;
				q.offer(nextPoint * 2);
			}
			if (nextPoint + 1 <= 100000 && isVisit[nextPoint + 1] == 0) {
				isVisit[nextPoint + 1] = isVisit[nextPoint] + 1;
				q.offer(nextPoint + 1);
			}
			if (nextPoint - 1 >= 0 && isVisit[nextPoint - 1] == 0) {
				isVisit[nextPoint - 1] = isVisit[nextPoint] + 1;
				q.offer(nextPoint - 1);
			}
		}
	}
}
