
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    final static int INF = Integer.MAX_VALUE;
    static int N;
    static int[][] num, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        num = new int[N][2];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            num[i][0] = Integer.parseInt(st.nextToken());
            num[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int k = 1; k < N; k++) {
            for (int i = 0; i + k < N; i++) {
                dp[i][i+k] = INF;

                for (int j = i; j < i + k; j++) {
                    dp[i][i + k] = Math.min(dp[i][i + k], dp[i][j] + dp[j + 1][i + k] + num[i][0]*num[j][1]*num[i+k][1]);
                }
            }
        }

        sb.append(dp[0][N-1]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
