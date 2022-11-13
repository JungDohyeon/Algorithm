package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ10026 {
    static class Pair {
        int x, y;

        public Pair(int x, int y){
            this.x =x;
            this.y = y;
        }
    }

    static int N;
    static char[][] normalColor;    // 정상인이 보는 색
    static char[][] discolor;   // 적록색약이 보는 색
    static boolean[][] normalVisited;
    static boolean[][] disVisited;

    // 사방탐색
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        normalColor = new char[N][N];
        discolor = new char[N][N];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j<N; j++) {
                char c = str.charAt(j);

                // 적록색약 입력
                if(c == 'G') {
                    discolor[i][j] = 'R';
                } else {
                    discolor[i][j] = c;
                }

                // 정상인은 그대로 입력
                normalColor[i][j] = c;
            }
        }

       normalVisited = new boolean[N][N];
        disVisited = new boolean[N][N];

        int normalCnt = 0;
        int disCnt = 0;

        for(int i=0; i<N; i++) {
            for(int j = 0; j<N; j++) {
                // 정상인
                if(!normalVisited[i][j]) {
                    DFS(new Pair(i, j), normalColor, normalVisited);
                    normalCnt++;
                }
                // 적록색약
                if(!disVisited[i][j]) {
                    DFS(new Pair(i, j), discolor, disVisited);
                    disCnt++;
                }
            }
        }

        System.out.println(normalCnt + " " + disCnt);
    }

    // DFS
    static void DFS(Pair p, char[][] cTable, boolean[][] visited) {
        Stack<Pair> st = new Stack<>();
        st.push(p);

        while(!st.isEmpty()) {
            Pair tmp = st.pop();
            for(int k = 0; k<4; k++) {
                int nx = tmp.x + dx[k];
                int ny = tmp.y + dy[k];

                if(checkValidation(nx, ny) && !visited[nx][ny] && cTable[tmp.x][tmp.y] == cTable[nx][ny]) {
                    visited[nx][ny] = true;
                    st.push(new Pair(nx, ny));
                }
            }
        }
    }

    // 범위 체크
    static boolean checkValidation(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}
