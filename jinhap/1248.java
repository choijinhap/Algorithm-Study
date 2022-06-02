import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1248 {
	static int N;
	static char[][] arr;
	static int[] ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		arr = new char[N][N];
		ans = new int[N];
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				arr[i][j] = str.charAt(cnt);
				cnt++;
			}
		}
		go(0);
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
	}

	static boolean go(int index) {
		if (index == N) {
			return true;
		}
		for (int i = -10; i <= 10; i++) {
			ans[index] = i;
			if (check(index) && go(index + 1))
				return true;
		}
		return false;
	}

	static boolean check(int index) {
		int sum = 0;
		for (int i = index; i >= 0; i--) {
			sum += ans[i];
			if (arr[i][index] == '0' && sum != 0)
				return false;
			if (arr[i][index] == '+' && sum <= 0)
				return false;
			if (arr[i][index] == '-' && sum >= 0)
				return false;

		}
		return true;
	}
}
