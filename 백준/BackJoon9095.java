package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon9095 {
   static  int[] dp = new int[12];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String l = br.readLine();
        StringTokenizer st = new StringTokenizer(l, " ");
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        for(int i = 0; i<n; i++){
            String num = br.readLine();
            st = new StringTokenizer(num, " ");
            int t = Integer.parseInt(st.nextToken());
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for(int j = 4; j<=t; j++){
                dp[j]  = dp[j-1] + dp[j-2] + dp[j-3];
            }
            sb.append(dp[t]).append("\n");
        }
        System.out.println(sb);
    }
}
