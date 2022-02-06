import java.util.List;
import java.util.Scanner;

public class Main {
	public static int N;
	public static int [][] arr;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		arr=new int[N][2];
		for(int i=0;i<N;i++) {
			arr[i][0]=sc.nextInt();
			arr[i][1]=sc.nextInt();
		}
		for(int i=0;i<N;i++) {
			int rank=1;
			for(int j=0;j<N;j++) {
				if(i!=j&&arr[i][0]<arr[j][0]&&arr[i][1]<arr[j][1]) rank++;
			}
			System.out.print(rank);
			if(i<N-1) System.out.print(" ");
		}
	}
}
