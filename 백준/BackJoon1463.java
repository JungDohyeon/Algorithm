package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon1463 {
    public static void main(String[] args) throws IOException {
        int[] dp = new int[10000000];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String l = br.readLine();
        StringTokenizer st = new StringTokenizer(l, " ");
        int n = Integer.parseInt(st.nextToken());
        dp[1] = 0;
        for(int i =2; i<=n; i++){
            dp[i] = dp[i-1] + 1;    // 1을 빼기

            if (i%2 == 0){
                dp[i] = Math.min(dp[i/2] + 1, dp[i]);
            }

            if(i%3 == 0){
                dp[i] = Math.min(dp[i/3] + 1 , dp[i]);
            }
        }
        System.out.println(dp[n]);
    }
}
