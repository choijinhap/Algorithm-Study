import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Edge implements Comparable<Edge> {
	int start;
	int end;
	double weight;

	Edge(int start, int end, double weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.weight > o.weight ? 1 : -1;
	}
}

public class Main_1774 {
	static int N;
	static int[] parents;
	static ArrayList<Edge> edgeList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
		int M = Integer.parseInt(st.nextToken());
		Point[] points = new Point[N + 1];
		// 우주신들의 좌표
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			points[i] = new Point(x, y);

		}

		// 이미 연결된 정점
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}

		// 모든 통로들 간의 간선정보 담아서 정렬하기
		edgeList = new ArrayList<Edge>();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				edgeList.add(new Edge(i, j, getDistance(points[i], points[j])));
			}
		}
		Collections.sort(edgeList);

		// 크루스칼 알고리즘
		double ans = 0;
		for (Edge edge : edgeList) {
			if (union(edge.start, edge.end)) {
				ans += edge.weight;
			}
		}
		System.out.println(String.format("%.2f", ans));
	}

	public static int find(int a) {
		if (parents[a] == a)
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

	public static double getDistance(Point a, Point b) {
		return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
	}
}
