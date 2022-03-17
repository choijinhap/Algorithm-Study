import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10815 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] myArr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < myArr.length; i++) {
			myArr[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		int[] arr = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(myArr);
		String answer = solve(arr, myArr);
		System.out.println(answer);
	}

	static String solve(int[] arr, int[] myArr) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			int left = 0;
			int right = myArr.length - 1;
			boolean flag = false;
			while (left <= right) {
				int center = (left + right) / 2;
				if (myArr[center] == arr[i]) {
					flag = true;
					break;
				} else {
					if (myArr[center] > arr[i]) {
						right = center - 1;
					} else {
						left = center + 1;
					}
				}
			}
			if (flag)
				sb.append("1 ");
			else
				sb.append("0 ");
		}
		return sb.toString();
	}
}
