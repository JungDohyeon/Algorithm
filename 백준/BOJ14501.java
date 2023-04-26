package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14501 {
   static class Work {
        int t, p;

        public Work(int t, int p) {
            this.t = t;
            this.p = p;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Work[] storage = new Work[N+1];
        int[] dp = new int[N+1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            storage[i] = new Work(t, p);
        }

        for (int i = 0; i < N; i++) {
            // 날짜가 넘어가지 않는 이상 저장.
            if (i + storage[i].t <= N) {
                dp[i + storage[i].t] = Math.max(dp[i + storage[i].t], dp[i] + storage[i].p);
            }

            // dp 갱신
            dp[i + 1] = Math.max(dp[i], dp[i + 1]);
        }

        System.out.println(dp[N]);
    }
}
