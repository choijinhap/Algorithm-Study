import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(new InputStreamReader(System.in));
		int T = in.nextInt();
		for (int t = 0; t < T; t++) {
			int x = in.nextInt();
			int y = in.nextInt();
			int dis = y - x;
			if (dis == 1) {
				System.out.println(1);
				continue;
			}
			;
			if (dis > (int) Math.sqrt(dis - 1) * (int) Math.sqrt(dis - 1) + (int) Math.sqrt(dis))
				System.out.println((int) Math.sqrt(dis - 1) * 2 + 1);
			else
				System.out.println((int) Math.sqrt(dis - 1) * 2);
		}

	}

}
