package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1189 {
    static char[][] map;
    static boolean[][] visited;
    static int R, C, K, ans;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];
        ans = 0;

        for(int i = 0; i < R; i++) {
            String str = br.readLine();
            for(int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        visited[R-1][0] = true;
        DFS(R-1, 0, 1);
        System.out.println(ans);
    }

    public static void DFS(int x, int y, int cnt) {
        if(x == 0 && y == C-1){
            if(cnt == K)
                ans++;
            return;
        }

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= R || ny >= C || visited[nx][ny] || map[nx][ny] == 'T')
                continue;

            visited[nx][ny] = true;
            DFS(nx, ny,cnt+1);
            visited[nx][ny] = false;
        }
    }
}
