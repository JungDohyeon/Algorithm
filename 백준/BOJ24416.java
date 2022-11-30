package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ24416 {
    static int[] dp;
    static int recurCnt;
    static int dpCnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        recurCnt = 1;
        dpCnt = 1;

        dp = new int[41];
        dp[1] = 1;
        dp[2] = 1;

        recurFib(n);
        dpFib(n);

        System.out.println(recurCnt + " " + dpCnt);
    }

    static int recurFib(int n) {
        if(n ==1 || n == 2) {
            return 1;
        } else {
            recurCnt++;
            return recurFib(n-1) + recurFib(n - 2);
        }
    }

    static int dpFib(int n) {
        for(int i = 3; i < n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
            dpCnt++;
        }
        return dp[n];
    }
}
