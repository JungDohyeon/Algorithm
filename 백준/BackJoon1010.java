package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon1010 {
    static int[][] dp;  // dp 저장 배열

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());    // 테스트 케이스 수

        for(int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine() ," ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            dp = new int[M+1][N+1];
            sb.append(combination(M, N) + "\n");
        }
        System.out.println(sb);
    }

    static int combination(int n, int r) {
        // 이미 계산된 결과라면 해당 값 반환
        if(dp[n][r] > 0) {
            return dp[n][r];
        }

        // 조합 성질 - 2 사용
        if (r == 0 || n == r) {
            return dp[n][r] = 1;
        }

        // 조합 성질 - 1 사용
        return dp[n][r] = combination(n-1, r-1) + combination(n-1, r);
    }
}

