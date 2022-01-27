import java.io.InputStreamReader;
import java.util.Scanner;

//while문으로 직접 돌리려다가 시간 오래걸려서 수식만들어서 계산함
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(new InputStreamReader(System.in));
		int A=sc.nextInt();
		int B=sc.nextInt();
		int V=sc.nextInt();
		int answer= 1+(int)Math.ceil((double)(V-A)/(A-B));
		System.out.println(answer);
	}

}
