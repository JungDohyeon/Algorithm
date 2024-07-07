
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static class Node {
        int x;
        int y;

        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    final static int[] dx = {0, 0, -1, 1};
    final static int[] dy = {1, -1, 0, 0};

    static int R, C, ans;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        ans = 0;

        map = new int[R][C];
        visited = new boolean[26];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();

            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j) - 'A';
            }
        }

        dfs(new Node(0, 0), 0);

        bw.write(String.valueOf(ans == 0 ? 1 : ans));
        bw.flush();
        bw.close();
    }

    private static void dfs(Node node, int cnt) {
        if(visited[map[node.x][node.y]]) {
            ans = Math.max(ans, cnt);
        } else {
            visited[map[node.x][node.y]] = true;

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= R || ny >= C)
                    continue;

                dfs(new Node(nx, ny), cnt + 1);
            }

            visited[map[node.x][node.y]] = false;
        }
    }
}
