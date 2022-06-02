import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1339 {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.out.println('A' - 65);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] map = new int[26];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			int size = line.length();
			int base = (int) Math.pow(10, size - 1);
			for (int j = 0; j < size; j++) {
				map[line.charAt(j) - 'A'] += base;
				base /= 10;
			}

		}
		Arrays.sort(map);
		int ans = 0;
		for (int i = 0; i < 10; i++) {
			ans += map[25 - i] * (9 - i);
		}
		System.out.println(ans);
	}
}
