package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1654 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long[] arr = new long[K];

        long maxLen = 0;
        for(int i = 0; i<K; i++) {
            arr[i] = Long.parseLong(br.readLine());
            if(arr[i] > maxLen)
                maxLen = arr[i];
        }

        long left = 1;
        long right = maxLen + 1;

        while(left < right) {
            long mid = (left + right) >> 1;
            long cnt = 0;

            for(int i = 0; i < K; i++) {
                cnt += (arr[i] / mid);
            }

            if (cnt < N) {
                right = mid;
            } else {
                left = mid + 1; // upper bound
            }
        }

        System.out.println(left - 1);
    }
}
