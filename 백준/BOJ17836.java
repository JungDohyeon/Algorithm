package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 공주님을 구해라!
public class BOJ17836 {
    static int N, M, T;
    static int[][] castle;
    static boolean[][][] visited;

    // 사방탐색
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static class Soldier {
        int x, y, dist;
        boolean sword;

        public Soldier(int x, int y, int dist, boolean sword) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.sword = sword;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());   // 제한 시간

        castle = new int[N][M];
        visited = new boolean[N][M][2]; // 검으로 찾은 길과 검이 없을 때 찾은 길 분리

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " " );
            for(int j = 0; j < M; j++) {
                castle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[0][0][castle[0][0] == 2 ? 1 : 0] = true;
        int res = bfs(new Soldier(0, 0, 0, castle[0][0] == 2));

        // 도달할 수 없는 경우 (-1) 또는 시간 초과인 경우 fail
        System.out.println(res == -1 || res > T ? "Fail" : res);
    }

    static int bfs(Soldier s) {
        Queue<Soldier> q = new LinkedList<>();
        q.add(s);

        while(!q.isEmpty()) {
            Soldier next = q.poll();

            // 만약 끝 점에 도달 했다면 경과 시간 반환
            if(next.x == N-1 && next.y == M-1) {
                return next.dist;
            }

            for(int k = 0; k < 4; k++) {
                int nx = next.x + dx[k];
                int ny = next.y + dy[k];

                if(checkValidation(nx, ny)) {
                    // 검을 가지고 있다면 어디든 갈 수 있다.
                    if(next.sword && !visited[nx][ny][1]){
                        q.add(new Soldier(nx, ny, next.dist+1, true));
                        visited[nx][ny][1] = true;
                    }

                    else {
                        // 일반 길인 경우
                        if(castle[nx][ny] == 0 && !visited[nx][ny][0]) {
                            q.add(new Soldier(nx, ny, next.dist+1, false));
                            visited[nx][ny][0] = true;
                        }
                        // 검을 만난 경우
                        else if (castle[nx][ny] == 2 && !visited[nx][ny][0]) {
                            q.add(new Soldier(nx, ny, next.dist+1, true));
                            visited[nx][ny][0] = true;
                        }
                    }
                }
            }
        }

        // 도달 하지 못한 경우는 -1 반환
        return -1;
    }

    // 범위 체크
    static boolean checkValidation(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}
