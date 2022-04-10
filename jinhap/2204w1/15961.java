import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15961 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] arr = new int[N + k - 1];
		int[] isPicked = new int[d + 1];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for (int i = N; i < N + k - 1; i++) {
			arr[i] = arr[i - N];
		}
		int answer = 0;
		int cnt = 0;
		for (int i = 0; i < k; i++) {
			if (isPicked[arr[i]] == 0)
				cnt++;
			isPicked[arr[i]]++;
		}
		answer = cnt;
		if (isPicked[c] == 0) {
			answer++;
		}
		int start = 0;
		for (int i = k; i < N + k - 1; i++) {
			isPicked[arr[start]]--;
			if (isPicked[arr[start]] == 0)
				cnt--;
			isPicked[arr[i]]++;
			if (isPicked[arr[i]] == 1)
				cnt++;

			answer = isPicked[c] == 0 ? Math.max(cnt + 1, answer) : Math.max(cnt, answer);
			start++;
		}
		System.out.println(answer);
	}
}
