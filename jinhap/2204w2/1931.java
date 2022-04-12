import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1931 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Meeting[] meetings = new Meeting[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(meetings);

		int cnt = 0;
		int lastEnd = 0;
		for (int i = 0; i < N; i++) {
			if (meetings[i].start >= lastEnd) {
				lastEnd = meetings[i].end;
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	static class Meeting implements Comparable<Meeting> {
		int start;
		int end;

		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting o) {
			// TODO Auto-generated method stub
			if (this.end == o.end) {
				return this.start - o.start;
			}
			return this.end - o.end;
		}

	}
}
