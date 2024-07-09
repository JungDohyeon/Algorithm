
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    static int[] dp, reverseDp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        dp = new int[N];
        reverseDp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j] && dp[j] >= dp[i])
                    dp[i] = dp[j] + 1;
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            reverseDp[i] = 1;

            for (int j = N-1; j > i; j--) {
                if(arr[i] > arr[j] && reverseDp[j] >= reverseDp[i])
                    reverseDp[i] = reverseDp[j] + 1;
            }
        }

        int res = 0;
        for (int i = 0; i < N; i++) {
            res = Math.max(res, dp[i] + reverseDp[i] - 1);
        }

        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
    }

}

