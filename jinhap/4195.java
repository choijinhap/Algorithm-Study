import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_4195 {
	public static Map<String, String> parents;
	public static Map<String, Integer> map;
	public static int F;

	public static String find(String a) {
		if (parents.get(a) == a)
			return a;
		else {
			parents.put(a, find(parents.get(a)));
			return parents.get(a);
		}
	}

	public static int union(String a, String b) {
		String aRep = find(a);
		String bRep = find(b);
		if (aRep.equals(bRep))
			return map.get(aRep);
		parents.put(aRep, bRep);
		int aNum = map.get(aRep);
		int bNum = map.get(bRep);
		map.put(aRep, aNum + bNum);
		map.put(bRep, aNum + bNum);
		return map.get(aRep);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int t = 1; t <= T; t++) {
			map = new HashMap<String, Integer>();
			parents = new HashMap<String, String>();
			F = Integer.parseInt(br.readLine());
			for (int f = 0; f < F; f++) {
				st = new StringTokenizer(br.readLine());
				String name1 = st.nextToken();
				String name2 = st.nextToken();
				if (parents.get(name1) == null) {
					parents.put(name1, name1);
					map.put(name1, 1);
				}
				if (parents.get(name2) == null) {
					parents.put(name2, name2);
					map.put(name2, 1);
				}
				System.out.println(union(name1, name2));

			}
		}
	}
}
