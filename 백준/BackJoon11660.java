package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon11660 {
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n+1][n+1];
        dp = new int[n+1][n+1];

        for(int i =1; i<=n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=1; j<=n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // Dynamic Programming
        for(int i =1; i<=n; i++){
            for (int j=1; j<=n; j++){
                // i,j 까지의 합은 좌, 우 더하고 대각 빼기 + 현 좌표 값 더하기
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + arr[i][j];
            }
        }

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            // x2,y2까지의 합 -
            int answer = dp[x2][y2] - dp[x2][y1-1] - dp[x1-1][y2] + dp[x1-1][y1-1];
            sb.append(answer + "\n");
        }
        System.out.println(sb);
    }
}