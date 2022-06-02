import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Integer.parseInt(st.nextToken());
		long b = Integer.parseInt(st.nextToken());
		long c = Integer.parseInt(st.nextToken());
		long answer = solve(a, b, c);
		System.out.println(answer);

	}

	public static long solve(long a, long b, long c) {
		if (b == 1)
			return a % c;
		long tmp=solve(a, b / 2, c);
		if (b % 2 == 0)
			return tmp*tmp % c;
		else
			return (tmp*tmp % c) * a % c;
	}
}
