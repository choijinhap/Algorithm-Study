import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_13023 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for (int i = 0; i < N; i++) {
			list.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list.get(from).add(to);
			list.get(to).add(from);
		}
		boolean[] visited=new boolean[N];
		for(int i=0;i<N;i++) {
			if(go(i,list,0,visited)) {
				System.out.println("1");
				return;
			}
		}
		System.out.println("0");
	}
	
	static boolean go(int node,List<List<Integer>> list,int cnt,boolean[] visited) {
		if(cnt+1==5) {
			return true;
		}
		visited[node]=true;
		for(int i=0;i<list.get(node).size();i++) {
			int to=list.get(node).get(i);
			if(!visited[to]) {
				if(go(to,list,cnt+1,visited)) return true;
			}
		}
		visited[node]=false;
		return false;
	}
}
