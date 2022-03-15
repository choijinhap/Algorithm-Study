import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1759 {
	static StringBuilder sb;
	static int L, C;
	static boolean[] visited;
	static char[] letters;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		visited = new boolean[C];
		letters = new char[C];
		st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		for (int i = 0; i < C; i++) {
			letters[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(letters);
		solve("", 0, 0,0);
		System.out.println(sb);
	}

	// letters에 있는 문자를 조합해 최소1개의 모음과 최소 2개의 자음으로 이루어진 오름차순 단어를 만든다
	public static void solve(String word, int mo, int ja,int start) {
		if (word.length() == L) {
			if (mo >= 1 && ja >= 2)
				sb.append(word + "\n");
			return;

		}
		for (int i = start; i < C; i++) {
			if (!visited[i]) {
				visited[i] = true;

				solve(word.concat(Character.toString(letters[i])), mo + checkMo(letters[i]),
						ja + 1 - checkMo(letters[i]),i);
				visited[i] = false;
			}
		}
	}

	static int checkMo(char a) {
		if (a == 'i' || a == 'e' || a == 'o' || a == 'u' || a == 'a')
			return 1;
		return 0;
	}
}
