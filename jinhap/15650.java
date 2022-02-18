import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static boolean[] isVisit;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		isVisit = new boolean[N + 1];
		arr = new int[M];
		solve(0,1);
	}

	public static void solve(int cnt,int start) {
		if (cnt == M) {
			for (int val : arr) {
				System.out.print(val + " ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i <= N; i++) {
			if (!isVisit[i]) {
				isVisit[i] = true;
				arr[cnt] = i;
				solve(cnt + 1,i+1);
				isVisit[i] = false;

			}
		}

	}

}
