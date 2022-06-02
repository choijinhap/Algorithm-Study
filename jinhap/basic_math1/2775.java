import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new InputStreamReader(System.in));
		int T = in.nextInt();
		int k, n;
		int[] arr;
		int[] temp;
		for (int t = 0; t < T; t++) {
			k = in.nextInt();
			n = in.nextInt();
			arr = new int[n];
			temp = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = i + 1;
				temp[i] = 0;
			}
			for (int i = 0; i < k; i++) {
				for (int j = 0; j < n; j++) {
					for (int l = 0; l <= j; l++) {
						temp[j] += arr[l];
					}
				}
				for (int j = 0; j < n; j++) {
					arr[j] = temp[j];
					if (i < k - 1)
						temp[j] = 0;
				}
			}
			System.out.println(temp[n - 1]);
		}
	}

}
