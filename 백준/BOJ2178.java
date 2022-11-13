package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2178 {
    static class Pair {
        int x, y, dist;

        public Pair(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static int N, M;
    static int[][] maze;
    static boolean[][] visited;

    // 사방 탐색
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        visited = new boolean[N][M];

        // 미로 정보 입력
        for(int i = 0; i<N; i++) {
            String str = br.readLine();
            for(int j = 0; j <M; j++) {
                maze[i][j] = str.charAt(j);
            }
        }

        bfs(new Pair(0, 0, 1));
    }

    // 거리 탐색 bfs
    static void bfs(Pair p) {
        Pair[] pairs = new Pair[N*M];
        int front =-1;
        int rear = -1;

        pairs[++rear] = p;

        visited[p.x][p.y] = true;

        while(front != rear) {
            Pair tmp = pairs[++front];

            // (N, M)에 도착하면 종료
            if(tmp.x== N-1 && tmp.y == M-1) {
                System.out.println(tmp.dist);
                break;
            }

            // 사방 탐색 시작
            for(int k = 0; k<4; k++) {
                int nx = tmp.x + dx[k];
                int ny  = tmp.y + dy[k];

                // 범위 내에 있고 방문하지 않았으며 길이 있는 경우
                if(checkValidation(nx, ny) && !visited[nx][ny] && maze[nx][ny] == '1')  {
                    visited[nx][ny] = true;
                    pairs[++rear] = new Pair(nx, ny, tmp.dist+1);
                }
            }
        }

    }

    // 범위 체크
    static boolean checkValidation(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}
