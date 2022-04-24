import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11723 {
	static boolean[] S = new boolean[21];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String op = st.nextToken();
			if (op.equals("all") || op.equals("empty")) {
				act(op);
			} else {
				int num = Integer.parseInt(st.nextToken());
				act(op, num);
			}
		}
		System.out.println(sb);
	}

	static void act(String op) {
		if (op.equals("all")) {
			for (int i = 1; i <= 20; i++) {
				S[i] = true;
			}
		} else if (op.equals("empty")) {
			for (int i = 1; i <= 20; i++) {
				S[i] = false;
			}
		}
	}

	static void act(String op, int num) {
		if (op.equals("add")) {
			S[num] = true;
		} else if (op.equals("check")) {
			if (S[num] == true)
				sb.append("1\n");
			else
				sb.append("0\n");
		} else if (op.equals("remove")) {
			S[num] = false;
		} else if (op.equals("toggle")) {
			S[num] = !S[num];
		}
	}
}
