package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2573 {
    static class  Pair{
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx= {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        // map input
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
               map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        int year = 0;

        while(true) {
            // DFS
            int maxH = 0;
            int part = 0;

            visited = new boolean[N][M];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    maxH = Math.max(maxH, map[i][j]);

                    if(map[i][j] > 0 && !visited[i][j]) {
                        DFS(i, j);
                        part++;
                    }
                }
            }

            // 두 부분 이상으로 나뉜 순간 년도 반환
            if(part >= 2) {
                ans = year;
                break;
            }


            // 절대로 두 부분으로 안나눠지는 경우
            if(maxH == 0) {
                break;
            }

            // map Update
            visited = new boolean[N][M];
            for(int i = 1; i < N-1; i++) {
                for(int j = 1; j < M-1; j++) {
                    if(map[i][j] > 0) {
                        int nearZero = 0;
                        visited[i][j] = true;
                        for(int k = 0; k < 4; k++) {
                            int nearx = i + dx[k];
                            int neary = j + dy[k];

                            if(nearx < 0 || neary < 0 || nearx >= N || neary >= M)
                                continue;

                            if(map[nearx][neary] == 0 && !visited[nearx][neary])
                                nearZero++;
                        }
                        map[i][j] = Math.max(map[i][j] - nearZero, 0);
                    }
                }
            }

            year++;
        }

        System.out.println(ans);
    }

    public static void DFS(int x, int y) {
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(x, y));
        visited[x][y] = true;

        while(!st.isEmpty()) {
            Pair p = st.pop();

            for(int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;

                if(map[nx][ny] != 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    st.push(new Pair(nx, ny));
                }
            }
        }
    }
}
