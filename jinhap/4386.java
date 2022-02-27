import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_4386 {
	static class Star {
		double x;
		double y;

		public Star(double x, double y) {
			this.x = x;
			this.y = y;
		}

	}

	public static double getDis(Star a, Star b) {
		return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		Star[] list = new Star[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			list[i] = new Star(x, y);
		}

		// 임의로 시작점하나 잡기
		int start = 0;
		// distance : 현재 만들어진 신장트리랑 최소거리를 담는 배열
		double[] distance = new double[N];
		distance[start] = 0;

		// distance배열 초기화
		for (int i = 0; i < N; i++) {
			distance[i] = getDis(list[start], list[i]);
		}

		// visited : 신장트리에 포함되있는지 여부
		boolean[] visited = new boolean[N];
		visited[start] = true;

		double ans = 0;
		// 신장트리에 포함되지 않은 정점을 뒤져가면서 제일 거리가 짧은 정점 트리에 포함시키기
		for (int j = 1; j < N; j++) {
			double min = Double.MAX_VALUE;
			int cur = 0;
			// 가장 가까운 정점하나 고르기
			for (int i = 0; i < N; i++) {
				if (!visited[i] && min > distance[i] && distance[i] != 0) {
					min = distance[i];
					cur = i;
				}
			}
			visited[cur] = true;
			ans += min;
			// 고른 정점을 포함시켜서 distance배열 업데이트
			for (int i = 0; i < N; i++) {
				if (!visited[i])
					distance[i] = Math.min(distance[i], getDis(list[cur], list[i]));
			}
		}
		System.out.println(String.format("%.2f", ans));
	}
}
