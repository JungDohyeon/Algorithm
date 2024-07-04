
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    private static class Node {
        int x;
        int y;
        int dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static int N, M;
    static int[][] map;
    static boolean[][] visited;

    final static int[] dx = {0, 0, 1, -1};
    final static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        Node target = null;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                int value = Integer.parseInt(st.nextToken());

                map[i][j] = value;

                if (value == 2) {
                    target = new Node(i, j, 0);
                    map[i][j] = 0;
                }
            }
        }

        bfs(target);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j])
                    sb.append(-1);
                else
                    sb.append(map[i][j]);

                sb.append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void bfs(Node target) {
        Queue<Node> q = new LinkedList<>();
        q.offer(target);

        visited[target.x][target.y] = true;

        while(!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;

                if (!visited[nx][ny] && map[nx][ny] != 0) {
                    visited[nx][ny] = true;
                    map[nx][ny] = cur.dist + 1;
                    q.offer(new Node(nx, ny, cur.dist + 1));
                }
            }
        }

    }
}
