import java.util.Scanner;

public class Main_1748 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int ans=0;
		for(int start=1,len=1;start<=N;start*=10,len++) {
			int end=start*10-1;
			if(end>N) {
				end=N;
			}
			ans+=(end-start+1)*len;
		}
		System.out.println(ans);
	}
}
