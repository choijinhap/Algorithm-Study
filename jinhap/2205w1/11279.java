import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_11279 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> queue = new PriorityQueue<Integer>((o1,o2)->o2-o1);
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			if (input == 0) {
				if (queue.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(queue.poll());
				}
			} else {
				queue.offer(input);
			}
		}
	}
}
