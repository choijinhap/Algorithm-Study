import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1080 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] matA = new int[N][M];
		int[][] matB = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				matA[i][j] = str.charAt(j) - '0';
			}
		}
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				matB[i][j] = str.charAt(j) - '0';
			}
		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (i <= N - 3 && j <= M - 3) {
					if (matA[i][j] != matB[i][j]) {
						cnt++;
						for (int r = 0; r < 3; r++) {
							for (int c = 0; c < 3; c++) {
								matA[i + r][j + c] = 1 - matA[i + r][j + c];
							}
						}
					}
				} else {
					if (matA[i][j] != matB[i][j]) {
						cnt = -1;
						System.out.println(cnt);
						return;
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
