package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon2579 {
    static int[] dp = new int[301];
    static int[] stair = new int[301];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line, " ");
        int n = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) {
            String a = br.readLine();
            st = new StringTokenizer(a, " ");
            int point = Integer.parseInt(st.nextToken());
            stair[i] = point;
        }

        dp[1] = stair[1];
        dp[2] = Math.max(stair[1] + stair[2], stair[2]);
        dp[3] = Math.max(stair[1] + stair[3], stair[2] + stair[3]);

        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] + stair[i], dp[i - 3] + stair[i - 1] + stair[i]);
        }

        System.out.println(dp[n]);
    }
}
