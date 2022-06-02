import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _1874 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Stack<Integer> stack = new Stack<>();
		int lastHigh = 0;
		for (int i = 0; i < n; i++) {
			if (stack.empty()) {
				stack.push(lastHigh);
			}
			while (true) {
				int peek = stack.peek();
				if (peek > arr[i]) {
					System.out.print("NO");
					return;
				}
				if (peek == arr[i]) {
					stack.pop();
					sb.append("-\n");
					break;
				} else {
					stack.push(++lastHigh);
					sb.append("+\n");
				}
			}
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}

}
