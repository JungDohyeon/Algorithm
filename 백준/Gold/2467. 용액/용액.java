
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        int left = 0;
        int right = N - 1;

        long ans = Long.MAX_VALUE;

        long v1 = arr[left];
        long v2 = arr[right];

        while(left < right) {
            long gap = arr[left] + arr[right];

            if (Math.abs(gap) < ans) {
                ans = Math.abs(gap);
                v1 = arr[left];
                v2 = arr[right];
            }

            if(gap > 0) {
                right--;
            } else if (gap == 0) {
                break;
            } else {
                left++;
            }
        }

        bw.write(v1 + " " + v2);
        bw.flush();
        bw.close();
    }
}
