package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ17626 {
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        for(int i = 0; i< n+1; i++) {
            dp[i] = 10;
        }

        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            for(int j = (int) Math.sqrt(i); j > 0; j--) {
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }

        System.out.println(dp[n]);
    }
}
