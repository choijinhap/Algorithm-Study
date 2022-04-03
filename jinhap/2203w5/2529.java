import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2529 {
	static long max = 0, min = Long.MAX_VALUE;
	static char[] chars;
	static int[] nums;
	static int K;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		nums = new int[K + 1];
		chars = new char[K];
		visited = new boolean[10];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			chars[i] = st.nextToken().charAt(0);
		}
		go(0);
		System.out.println(max);
		System.out.println(Math.floor(min / Math.pow(10, K )) < 1 ? "0" + min : min);
	}

	static void go(int step) {
		if (step == K + 1) {
			long tmp = 1;
			long sum = 0;
			for (int i = 0; i < K + 1; i++) {
				sum += nums[K - i] * tmp;
				tmp *= 10;
			}
			max = Math.max(sum, max);
			min = Math.min(sum, min);
			return;
		}
		for (int i = 0; i < 10; i++) {
			if (!visited[i]) {
				if (step == 0 || (chars[step - 1] == '>' && nums[step - 1] > i)
						|| (chars[step - 1] == '<' && nums[step - 1] < i)) {
					visited[i] = true;
					nums[step] = i;
					go(step + 1);
					visited[i] = false;
				}
			}
		}
	}
}
