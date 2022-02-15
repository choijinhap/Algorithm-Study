import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				arr[i][j] = c[j] - '0';
			}
		}
		solve(N, 0, 0);
		System.out.println(sb);
	}

	public static void solve(int n, int x, int y) {

		if (isPossible(n,x, y)) {
			sb.append(arr[x][y]);
			return;
		}

		int newSize = n / 2;

		sb.append('(');

		solve(newSize,x, y);
		solve(newSize,x, y + newSize);
		solve(newSize,x + newSize, y);
		solve(newSize,x + newSize, y + newSize);

		sb.append(')');

	}

	public static boolean isPossible(int n, int x, int y) {
		int value = arr[x][y];

		for (int i = x; i < x + n; i++) {
			for (int j = y; j < y + n; j++) {
				if (value != arr[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

}
