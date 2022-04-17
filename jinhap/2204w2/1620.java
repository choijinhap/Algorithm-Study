import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_1620 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<String, String> pocketmonsByNum = new HashMap<String, String>();
		Map<String, String> pocketmonsByName = new HashMap<String, String>();
		for (int i = 1; i <= N; i++) {
			String name=br.readLine();
			pocketmonsByNum.put(Integer.toString(i), name);
			pocketmonsByName.put(name, Integer.toString(i));
		}
		for(int i=0;i<M;i++) {
			String ask=br.readLine();
			String answer;
			if((answer=pocketmonsByName.get(ask))!=null) {
				System.out.println(answer);
			}else {
				System.out.println(pocketmonsByNum.get(ask));
			}
		}
	}
}
