package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14889 {
    static int N;
    static boolean[] visited;
    static int[][] board;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());

        board = new int[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = Integer.MAX_VALUE;
        visited = new boolean[N];
        makeTeam(0, 0);

        System.out.println(ans);
    }

    static void makeTeam (int idx, int depth) {
        if (depth == N/2) {
            calMin();
            return;
        }

        for(int i = idx; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                makeTeam(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    static void calMin() {
        int start = 0;
        int link = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i; j < N; j++) {
                if (visited[i] && visited[j]) {
                    start += board[i][j];
                    start += board[j][i];
                } else if (!visited[i] && !visited[j]) {
                    link += board[i][j];
                    link += board[j][i];
                }
            }
        }

        int tmp = Math.abs(start - link);
        ans = Math.min(tmp, ans);
    }
}
