
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] memory, cancel;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        memory = new int[N];
        cancel = new int[N];
        dp = new int[N][10001];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cancel[i] = Integer.parseInt(st.nextToken());
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 10001; j++) {
                if(i == 0) {
                    if (j >= cancel[i]) {
                        dp[i][j] = memory[i];
                    }
                } else {
                    if (j >= cancel[i]) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cancel[i]] + memory[i]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
                
                if (M <= dp[i][j]) {
                    ans = Math.min(ans, j);
                }
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
