import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import sun.util.locale.StringTokenIterator;

public class Main_1780 {
	static int answer1, answer2, answer3;
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		check(0, 0, N);
		System.out.println(answer1);
		System.out.println(answer2);
		System.out.println(answer3);
	}

	static void check(int startX, int startY, int size) {
		int start = arr[startX][startY];
		if (size == 1) {
			if (start == -1)
				answer1++;
			else if (start == 0)
				answer2++;
			else if (start == 1)
				answer3++;
			return;
		}
		for (int i = startX; i < startX + size; i++) {
			for (int j = startY; j < startY + size; j++) {
				if (arr[i][j] != start) {
					check(startX, startY, size / 3);
					check(startX + size / 3, startY, size / 3);
					check(startX + size * 2 / 3, startY, size / 3);
					check(startX, startY + size / 3, size / 3);
					check(startX + size / 3, startY + size / 3, size / 3);
					check(startX + size * 2 / 3, startY + size / 3, size / 3);
					check(startX, startY + size * 2 / 3, size / 3);
					check(startX + size / 3, startY + size * 2 / 3, size / 3);
					check(startX + size * 2 / 3, startY + size * 2 / 3, size / 3);
					return;
				}
			}
		}
		if (start == -1)
			answer1++;
		else if (start == 0)
			answer2++;
		else if (start == 1)
			answer3++;
		return;
	}
}
