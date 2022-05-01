import java.util.Arrays;
import java.util.Scanner;

public class Main_1755 {
	static String numToString[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
	// 숫자를 문자로 변환할 때 사용할 배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int size = N - M + 1;
		Node node[] = new Node[size];

		int idx = M;
		for (int i = 0; i < size; i++) {
			node[i] = new Node(idx);
			idx++;
		}

		Arrays.sort(node);
		for (int i = 0; i < size; i++) {
			if (i != 0 && i % 10 == 0)
				System.out.println();
			System.out.print(node[i].number + " ");
		}
	}

	static class Node implements Comparable<Node> {
		int number;
		String numberToString;

		public Node(int number) {
			super();
			this.number = number;
			int num10 = number / 10; 
			int num1 = number % 10; 

			if (number >= 10) {
				numberToString = numToString[num10] + " " + numToString[num1];
			} else {
				numberToString = numToString[num1];
			}
		}

		@Override
		public int compareTo(Node o) {
			return this.numberToString.compareTo(o.numberToString);
		}

	}
}
