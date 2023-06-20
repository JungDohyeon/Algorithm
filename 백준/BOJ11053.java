package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11053 {
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());  // input Array
            dp[i + 1] = 1;   // init DP Array
        }

        dp[0] = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i] && dp[i + 1] < dp[j + 1] + 1) {
                    dp[i + 1] = dp[j + 1] + 1;
                }
            }
        }

        int max = 0;
        for(int i = 1; i <= n; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
