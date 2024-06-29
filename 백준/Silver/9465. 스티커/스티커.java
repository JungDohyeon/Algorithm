
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int n, max;
    static int[][] sticker;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            n = Integer.parseInt(br.readLine());
            max = 0;
            sticker = new int[2][n];
            dp = new int[2][n];

            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());

                for (int k = 0; k < n; k++) {
                    sticker[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][0] = sticker[0][0];
            dp[1][0] = sticker[1][0];
            
            int max = Math.max(dp[0][0], dp[1][0]);
            
            for (int k = 1; k < n; k++) {
                if (k == 1) {
                    dp[0][k] = dp[1][0] + sticker[0][1];
                    dp[1][k] = dp[0][0] + sticker[1][1];
                    max = Math.max(sticker[0][k], sticker[1][k]);
                    continue;
                }

                dp[0][k] = Math.max(dp[1][k-1], dp[1][k-2]) + sticker[0][k];
                dp[1][k] = Math.max(dp[0][k-1], dp[0][k-2]) + sticker[1][k];
            }

            max = Math.max(max, Math.max(dp[0][n-1], dp[1][n-1]));
            sb.append(max).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
