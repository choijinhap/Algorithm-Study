import java.util.Scanner;

public class Main_10830 {
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		long B = sc.nextLong();
		int[][] matrix = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = sc.nextInt()%1000;
			}
		}
		matrix = solve(matrix, B);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] matrixMul(int[][] a, int[][] b) {
		int[][] ret = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int sum = 0;
				for (int k = 0; k < N; k++) {
					sum += a[i][k] * b[k][j];
				}
				ret[i][j] = sum % 1000;
			}
		}
		return ret;
	}

	public static int[][] solve(int[][] matrix, long b) {
		if (b <= 1)
			return matrix;
		int[][] newM=new int[N][N];
		newM=solve(matrix, b / 2);
		if (b % 2 == 0)
			return matrixMul(newM, newM);
		else
			return matrixMul(matrixMul(newM,newM), matrix);
//		return matrixMul(solve(matrix,b-1), matrix);
	}
}
