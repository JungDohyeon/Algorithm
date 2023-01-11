package COGO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 연속 부분 합 (최대 값 구하기 - dp)
public class partialSum {
    static long dp[];
    static int arr[];
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new long[n];
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        long max = dp[0];

        for(int i = 1; i < n; i++) {
            dp[i]  = Math.max(dp[i - 1], 0) + arr[i];
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
