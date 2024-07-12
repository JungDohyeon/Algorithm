
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    final static int[] dx = {0, 0, 1, -1};
    final static int[] dy = {1, -1, 0, 0};

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        setWall(0);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void setWall(int count) {
        if (count == 3) {
            activateVirus();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    setWall(count + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void activateVirus() {
        int[][] tmpMap = new int[N][M];
        visited = new boolean[N][M];

        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmpMap[i][j] = map[i][j];

                if(tmpMap[i][j] == 2) {
                    visited[i][j] = true;
                    q.add(new Node(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;

                if(!visited[nx][ny] && tmpMap[nx][ny] == 0) {
                    tmpMap[nx][ny] = 2;
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny));
                }
            }
        }

        solution(tmpMap);
    }

    private static void solution(int[][] final_map) {
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(final_map[i][j] == 0)
                    cnt++;
            }
        }

        result = Math.max(result, cnt);
    }
}