import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_18870 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] sortedArr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sortedArr[i] = arr[i];
		}
		Arrays.sort(sortedArr);

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int rank = 0;
		for (int num : sortedArr) {
			if (!map.containsKey(num)) {
				map.put(num, rank);
				rank++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int num : arr) {
			sb.append(map.get(num) + " ");
		}
		System.out.println(sb);
	}
}
