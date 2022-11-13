package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon11726 {
    static int[] dp = new int[1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String l = br.readLine();
        StringTokenizer st = new StringTokenizer(l, " ");
        int n = Integer.parseInt(st.nextToken());
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=n; i++){
            dp[i] = (dp[i-1] + dp[i-2])%10007;
        }
        System.out.println(dp[n]%10007);
    }
}
