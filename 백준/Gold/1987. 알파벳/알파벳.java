
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    final static int[] dx = {0, 0, -1, 1};
    final static int[] dy = {1, -1, 0, 0};

    static int R, C, ans;
    static int[][] map;
    static int[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        ans = 0;

        map = new int[R + 2][C + 2];
        visited = new int[R + 1][C + 1];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();

            for (int j = 0; j < C; j++) {
                map[i + 1][j + 1] = str.charAt(j) - 'A';
            }
        }

        int first = map[1][1];
        Arrays.fill(map[0], first);
        Arrays.fill(map[R + 1], first);
        for (int i = 0; i < R + 2; i++){
            for (int j : new int[]{0, C + 1}){
                map[i][j] = first;
            }
        }

        dfs(1, 1, 1 << first, 1);

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }

    private static void dfs(int x, int y, int bit, int cnt) {
        ans = Math.max(ans, cnt);

        if (ans == 26)
            return;

        visited[x][y] = bit;

        for (int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if ((bit & 1 << map[nx][ny]) == 0 &&
                    (bit | 1 << map[nx][ny]) != visited[nx][ny]) {
                dfs(nx, ny, bit | 1 << map[nx][ny], cnt + 1);
            }
        }
    }
}
