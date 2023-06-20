package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ10844 {
    static long[][] dp;
    static long mod = 1000000000;

    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        dp = new long[n+1][10]; // [n][해당 자릿수에 대한 수]

        // 1의 자리에서는 각 1개씩 총 9 -> dp[1][n] = 1
        for(int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for(int j = 0; j < 10; j++) {
                // 현재 0일때 이전 수는 1만 가능.
                if(j == 0) {
                    dp[i][j] = dp[i-1][1] % mod;
                }
                // 9일때 이전 수는 8만 가능
                else if(j == 9) {
                    dp[i][j] = dp[i-1][8] % mod;
                }

                // 나머지 모든 경우 +1, -1
                else {
                    dp[i][j] = (dp[i-1][j-1]%mod) + (dp[i-1][j+1]%mod);
                }
            }
        }

        long ans = 0;

        for(int i = 0; i <= 9; i++) {
            ans += dp[n][i];
        }

        System.out.println(ans % mod);
    }
}
