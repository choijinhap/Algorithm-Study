import java.util.Scanner;

public class Main {
	static int N;
	static int[] input;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			input[i] = sc.nextInt();
		}
		int cnt = sc.nextInt();
		for (int i = 0; i < cnt; i++) {
			work(sc.nextInt(), sc.nextInt());
		}
		for (int i = 1; i <= N; i++) {
			System.out.print(input[i] + " ");
			if (i % 20 == 0)
				System.out.println();
		}
	}

	public static void work(int sex, int num) {
		if (sex == 1) {
			for (int i = 1; i <= N; i++) {
				if (i % num == 0) {
					input[i] = input[i] == 0 ? 1 : 0;
				}
			}
		} else {
			int left = num - 1;
			int right = num + 1;
			input[num] = input[num] == 0 ? 1 : 0;
			while (left >= 1 && right <= N) {
				if (input[left] == input[right]) {
					input[left] = input[right] = input[left] == 0 ? 1 : 0;
					left--;
					right++;
				}else break;
			}
		}
	}
}
