import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14500 {
	static int[][][] shape = {
			// 1자막대
			{ { 0, 1 }, { 0, 2 }, { 0, 3 } }
			, { { 1, 0 }, { 2, 0 }, { 3, 0 } },
			// 네모
			{ { 0, 1 }, { 1, 0 }, { 1, 1 } },
			// ㄱ자
			{ { -1, 0 }, { -2, 0 }, { 0, 1 } },
			{ { 0, 1 }, { 0, 2 }, { -1, 2 } },
			{ { 0, 1 }, { 1, 1 }, { 2, 1 } },
			{ { 1, 0 }, { 0, 1 }, { 0, 2 } },

			{ { 0, 1 }, { -1, 1 }, { -2, 1 } },
			{ { 0, 1 }, { 0, 2 }, { 1, 2 } },
			{ { 0, 1 }, { 1, 0 }, { 2, 0 } },
			{ { 1, 0 }, { 1, 1 }, { 1, 2 } },

			// ㄱ_ 자
			{ { 1, 0 }, { 1, 1 }, { 2, 1 } },
			{ { 0, 1 }, { -1, 1 }, { -1, 2 } },
			{ { -1, 0 }, { -1, 1 }, { -2, 1 } },
			{ { 0, 1 }, { 1, 1 }, { 1, 2 } },

			// ㅗ자
			{ { 0, 1 }, { -1, 1 }, { 0, 2 } },
			{ { 1, 0 }, { 2, 0 }, { 1, 1 } },
			{ { 0, 1 }, { -1, 1 }, { 1, 1 } },
			{ { 0, 1 }, { 1, 1 }, { 0, 2 } } 
			};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int sum = 0;
				for (int a = 0; a < shape.length; a++) {
					sum = arr[i][j];
					for (int b = 0; b < shape[a].length; b++) {
						int nx = i + shape[a][b][0];
						int ny = j + shape[a][b][1];
						if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
							sum += arr[nx][ny];
						} else {
							sum = -1;
							break;
						}
					}
					if (sum > answer)
						answer = sum;
				}
			}
		}
		System.out.println(answer);
	}
}
