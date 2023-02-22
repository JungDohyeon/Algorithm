package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ4963 {
    static int W, H;
    static int[][] board;
    static boolean[][] visited;
    static int cnt;

    static int[] dx = {1, 0, -1, 1, -1, -1, 1, 0};
    static int[] dy = {1, 1, 1, 0, 0, -1, -1, -1};

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            // 0 0 이면 종료
            if(W == 0 & H == 0)
                break;

            // init
            visited = new boolean[H][W];
            board = new int[H][W];
            cnt = 0;

            // 지도 입력 받기
            for(int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < W; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 맵을 돌면서 탐색 시작
            for(int i = 0; i < H; i++) {
                for(int j = 0; j < W; j++) {
                    // 방문하지 않았으며 땅인 경우 탐색
                    if(!visited[i][j] && board[i][j] == 1) {
                        cnt++;
                        Search(i, j);
                    }
                }
            }
            sb.append(cnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    // DFS
    public static void Search(int x, int y) {
        visited[x][y] = true;
        Stack<Pair> st = new Stack<>();

        st.push(new Pair(x, y));

        while(!st.empty()) {
            Pair p = st.pop();

            for(int i = 0; i < 8; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                // 맵 밖을 벗어나거나 이미 방문했던 점이라면 패스
                if(nx < 0 || ny < 0 || nx >= H || ny >= W || visited[nx][ny])
                    continue;

                // 방문하지 않았으며 땅인 경우 탐색
                if(!visited[nx][ny] && board[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    st.push(new Pair(nx, ny));
                }
            }
        }
    }
}
