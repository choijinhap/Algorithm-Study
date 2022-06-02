import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		int N = sc.nextInt();
		int level=1;
		int sum=1;
		while(sum<N) {
			level++;
			sum+=level;
		}
		if(level%2==0) {
			System.out.println((level+N-sum)+"/"+(sum-N+1));
		}else {
			System.out.println((sum-N+1)+"/"+(level+N-sum));
		}
	}

}
