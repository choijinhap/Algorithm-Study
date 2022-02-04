import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	public static int answer = 0;
	public static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		int N = sc.nextInt();
		sb = new StringBuilder();
		move(N, 1, 2, 3);
		System.out.println(answer);
		System.out.println(sb);
	}

//	public static int count(int n) {
//		if (n == 1)
//			return 1;
//		return count(n - 1) * 2 + 1;
//	}

	public static void move(int n, int from, int remain, int to) {
		if (n == 0)
			return;
		// n-1번째껀 남는칸에 옮기고
		move(n - 1, from, to, remain);
		// n번째를 목적지에 옮기고
		sb.append(from + " " + to + "\n");
		answer++;
		// n-1번쨰 애들을 목적지에 다시 옮기면 완성
		move(n - 1, remain, from, to);
	}
}
