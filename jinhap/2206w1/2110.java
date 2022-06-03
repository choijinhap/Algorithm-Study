import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int right = arr[N - 1] - arr[0] + 1;
        int left = 1;
        while (left < right) {
            int mid = (right + left) / 2;
            if (getNum(mid) < C) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left - 1);
    }

    static int getNum(int distance) {
        int count = 1;
        int lastLocate = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int locate = arr[i];
            if (locate - lastLocate >= distance) {
                count++;
                lastLocate = locate;
            }
        }
        return count;
    }
}
