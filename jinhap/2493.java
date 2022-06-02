import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<int[]> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (stack.empty())
				answer.append(0 + " ");
			else {
				while (true) {
					int[] data = stack.peek();
					int index = data[0];
					int height = data[1];
					if (height > num) {
						answer.append(index + " ");
						break;
					} else {
						stack.pop();
					}
					if (stack.empty()) {
						answer.append(0 + " ");
						break;
					}
				}
			}
			stack.push(new int[] { i + 1, num });
		}
		System.out.println(answer);
	}
}
