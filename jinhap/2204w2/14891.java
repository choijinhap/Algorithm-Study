import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14891 {
	static int[][] Gears;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Gears = new int[4][8];
		for (int i = 0; i < 4; i++) {
			String str=br.readLine();
			for (int j = 0; j < 8; j++) {
				Gears[i][j] = str.charAt(j)-'0';
			}
		}
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int gearNum = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken());
			go(gearNum, dir);
		}
		System.out.println(getScore());
	}

	static void rotate(int gearNum, int dir) {
		// dir: 1 => 시계방향 -1=> 반시계방향
		if (dir == 1) {
			int tmp = Gears[gearNum][7];
			for (int i = 7; i > 0; i--) {
				Gears[gearNum][i] = Gears[gearNum][i - 1];
			}
			Gears[gearNum][0] = tmp;

		} else {
			int tmp = Gears[gearNum][0];
			for (int i = 0; i < 7; i++) {
				Gears[gearNum][i] = Gears[gearNum][i + 1];
			}
			Gears[gearNum][7] = tmp;
		}
	}

	static void go(int gearNum, int dir) {
		Queue<int[]> q = new LinkedList<int[]>();
		int tmp = dir * -1;
		q.offer(new int[] { gearNum, dir });
		for (int i = gearNum; i < 4 - 1; i++) {
			int right = Gears[i][2];
			if (right != Gears[i + 1][6]) {
				q.offer(new int[] { i + 1, tmp });
				tmp *= -1;
			} else
				break;
		}
		tmp = dir * -1;
		for (int i = gearNum; i > 0; i--) {
			int left = Gears[i][6];
			if (left != Gears[i - 1][2]) {
				q.offer(new int[] { i - 1, tmp });
				tmp *= -1;
			} else
				break;
		}
		while (!q.isEmpty()) {
			int[] poll = q.poll();
			rotate(poll[0], poll[1]);
//			printGears();
		}
	}

	static int getScore() {
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			if (Gears[i][0] == 1)
				sum += 1 << i;
		}
		return sum;
	}

	static void printGears() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(Gears[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("=====================");
	}
}
