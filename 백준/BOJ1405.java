package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1405 {
    // 탐색 방향 - 동, 서, 남, 북
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static double[] dir;
    static boolean[][] visited;
    static int N;
    static double ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        dir = new double[4];
        visited = new boolean[30][30];
        ans = 0;

        for(int i = 0; i < 4; i++) {
            dir[i] = Integer.parseInt(st.nextToken()) * 0.01;
        }

        visited[15][15] = true;
        DFS(15, 15, 0, 1);
        System.out.println(ans);
    }

    public static void DFS(int x, int y, int cnt, double res) {
        // 최대 이동 횟수에 도달한 경우
        if(cnt == N) {
            ans += res;
            return;
        }

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= 30 || ny >= 30)
                continue;

            if(!visited[nx][ny]) {
                visited[nx][ny] = true;
                DFS(nx, ny, cnt+1, res * dir[i]);
                visited[nx][ny] = false;
            }
        }
    }
}
