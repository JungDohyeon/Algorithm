package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2206 {
    static class Pair {
        int x, y, dist, crash;

        public Pair(int x, int y,  int dist, int crash) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.crash = crash;
        }
    }

    static char[][] board;
    static boolean[][][] visited;
    static int N, M;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        visited = new boolean[N][M][2];     // 벽 부셨는지 안부셨는지 체크

        for(int i = 0; i<N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        // 시작지점과 도착지점이 같을 경우
        if(N-1 == 0 && M-1 == 0){
            System.out.print(1);
            System.exit(0);
        }

        System.out.println(BFS());
    }

    public static int BFS() {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, 0,  1, 0));
        visited[0][0][0] = true;

        while(!q.isEmpty()) {
            Pair p = q.poll();

            for(int i = 0; i < 4; i++ ){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx == N-1 && ny == M-1) {
                    return p.dist+1;
                }

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                // 벽을 만난 경우
                if(board[nx][ny] == '1') {
                    if(p.crash == 0 && !visited[nx][ny][1]) {
                        visited[nx][ny][1] = true;
                        q.offer(new Pair(nx, ny,  p.dist + 1, 1));
                    }
                }

                // 벽이 아닌 경우
                else {
                    if(!visited[nx][ny][p.crash]) {
                        q.offer(new Pair(nx, ny, p.dist+1, p.crash));
                        visited[nx][ny][p.crash] = true;
                    }
                }
            }
        }

        return -1;
    }
}
