
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    // U, D, L, R
    final static int[] dx = {-1, 1, 0, 0};
    final static int[] dy = {0 , 0, -1, 1};

    static int N, M, cnt;
    static int[][] map;
    static boolean[][] visited, safeZone;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        safeZone = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < M; j++) {
                switch (str.charAt(j)) {
                    case 'U':
                        map[i][j] = 0;
                        break;
                    case 'D':
                        map[i][j] = 1;
                        break;
                    case 'L':
                        map[i][j] = 2;
                        break;
                    case 'R':
                        map[i][j] = 3;
                        break;
                }
            }
        }

        cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                }
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        int nx = x + dx[map[x][y]];
        int ny = y + dy[map[x][y]];

        if(!visited[nx][ny]) {
            dfs(nx, ny);
        }else {
            if(!safeZone[nx][ny])
                cnt++;
        }

        safeZone[x][y] = true;
    }
}
