import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14225 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		boolean[] check = new boolean[2000001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < (1 << N); i++) {
			int sum = 0;
			for (int k = 0; k < N; k++) {
				if ((i & (1 << k)) > 0) {
					sum += arr[k];
				}
			}
			check[sum] = true;
		}
		for (int i = 1; i < check.length; i++) {
			if (!check[i]) {
				System.out.println(i);
				break;
			}
		}

	}
}
