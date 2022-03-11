import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_2108 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
			if (arr[i] > max)
				max = arr[i];
			if (arr[i] < min)
				min = arr[i];
		}
		if (N == 1) {
			System.out.println(arr[0]);
			System.out.println(arr[0]);
			System.out.println(arr[0]);
			System.out.println(0);
			return;
		}
		Arrays.sort(arr);
		int avg = (int) Math.round((double) sum / N);
		System.out.println(avg);
		System.out.println(arr[N / 2]);
		// 최빈값
		int cnt = 1;
		int maxCnt = 1;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			if (i + 1 < N && arr[i] == arr[i + 1])
				cnt++;
			else {
				if (cnt > maxCnt) {
					maxCnt = cnt;
					list.clear();
					list.add(arr[i]);
				} else if (cnt == maxCnt) {
					list.add(arr[i]);
				}
				cnt = 1;

			}
		}
		if (list.size() > 1)
			System.out.println(list.get(1));
		else
			System.out.println(list.get(0));
		System.out.println(max - min);
	}

}
