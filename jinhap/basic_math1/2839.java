import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(new InputStreamReader(System.in));
		int N = in.nextInt();
		int answer;
		if (N == 4 || N == 7) {
			answer = -1;
		} else if (N % 5 == 0) {
			answer = (N / 5);
		} else if (N % 5 == 1 || N % 5 == 3) {
			answer = (N / 5) + 1;
		} else {
			answer = (N / 5) + 2;
		}
		System.out.println(answer);
	}

}
