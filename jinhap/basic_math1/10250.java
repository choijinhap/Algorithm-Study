import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new InputStreamReader(System.in));
		int T = in.nextInt();
		for (int t = 0; t < T; t++) {
			int H = in.nextInt();
			int W = in.nextInt();
			int N = in.nextInt();
			int floor;
			int no;

			floor = N % H;
			no = N / H + 1;
			//이거 찾느라 오래걸림
			if (floor == 0) {
				floor = H;
				no--;
			}
			;
			String answer = Integer.toString(floor) + (no < 10 ? "0" + no : no);
			System.out.println(answer);
		}
	}

}
