import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18111 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int lowest = 256;
		int highest = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > highest)
					highest = map[i][j];
				if (map[i][j] < lowest)
					lowest = map[i][j];
			}
		}
		int ansCnt = Integer.MAX_VALUE;
		int ansHeight = lowest;
		for (int k = lowest; k <= highest; k++) {
			int cnt = 0;
			int b = B;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] < k) {
						cnt += k - map[i][j];
						b -= k - map[i][j];
					} else if (map[i][j] > k) {
						cnt += 2 * (map[i][j] - k);
						b += map[i][j] - k;
					}
				}
			}
			if (b >= 0 && cnt <= ansCnt) {
				ansCnt = cnt;
				if (k > ansHeight)
					ansHeight = k;
			}
		}
		System.out.println(ansCnt + " " + ansHeight);
	}
}
