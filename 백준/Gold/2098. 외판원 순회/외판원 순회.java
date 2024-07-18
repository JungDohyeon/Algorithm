
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] W, dp;
    static int MAX = 16000001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        dp = new int[N][(1 << N) - 1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++)
            Arrays.fill(dp[i], -1);

        bw.write(String.valueOf(dfs(0, 1)));
        bw.flush();
        bw.close();
        br.close();
    }

    private static int dfs (int cur, int route) {
        if (route == (1 << N) - 1) {
            if (W[cur][0] == 0)
                return MAX;

            return W[cur][0];
        }

        if(dp[cur][route] != -1)
            return dp[cur][route];

        dp[cur][route] = MAX;

        for (int i = 0; i < N; i++) {
            if((route & (1 << i)) == 0 && W[cur][i] != 0) {
                dp[cur][route] = Math.min(dfs(i, route | (1 << i)) + W[cur][i], dp[cur][route]);
            }
        }

        return dp[cur][route];
    }
}