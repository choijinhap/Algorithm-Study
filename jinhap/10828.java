import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_10828 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String op = st.nextToken();
			if (op.equals("push")) {
				stack.push(Integer.parseInt(st.nextToken()));
			} else if (op.equals("top")) {
				if (!stack.isEmpty())
					sb.append(stack.peek() + "\n");
				else
					sb.append("-1" + "\n");
			} else if (op.equals("size")) {
				sb.append(stack.size() + "\n");
			} else if (op.equals("empty")) {
				sb.append(stack.isEmpty() == true ? "1" + "\n" : "0" + "\n");
			} else if (op.equals("pop")) {
				if (!stack.isEmpty())
					sb.append(stack.pop() + "\n");
				else
					sb.append("-1" + "\n");
			}
		}
		System.out.println(sb);
	}
}
