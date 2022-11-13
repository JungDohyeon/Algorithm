package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14500 {

    // 만들 수 있는 도형 - ㅗ 모양 제외 상, 하, 좌, 우 가능
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    // ㅗ 모양 처리
    static int[][][] exception = {
            { { 0, 0 }, { 1, -1 }, { 1, 0 }, { 1, 1 } },   // ㅗ
            { { 0, 0 }, { -1, -1}, { 0, -1}, { 1, -1} },   // ㅏ
            { { 0, 0 }, { -1, -1}, { -1, 0}, { -1, 1} },   // ㅜ
            { { 0, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 } },   // ㅓ
    };

    static int[][] board;
    static boolean[][] visited;

    static int ans;
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());   // N
        M = Integer.parseInt(st.nextToken());   // M

        board = new int[N][M];
        visited = new boolean[N][M];

        // 보드 채우기
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            for(int j = 0; j<M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 최댓값 계산
        for(int i = 0; i<N; i++) {
            for(int j = 0; j<M; j++) {
                visited[i][j] = true;
                dfs(i, j, 0, 0);
                visited[i][j] = false;

                // ㅗ 모양 계산
                exception_shape(i, j);
            }
        }
        System.out.println(ans);
    }


    // dfs  - ㅗ 모양 제외 모두 계산
    static void dfs(int x, int y, int count, int val) {
        // 도형이 완성 되었을 때 최댓값 갱신 == 도형은 4개의 정사각형으로 구현되어 있음
        if (count == 4) {
            ans = Math.max(ans, val);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위를 벗어난 경우
            if (checkValidation(nx, ny) && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, count+1, val + board[nx][ny]);
                // 나중에 다시 방문해야 하기 때문에 방문 흔적 제거
                visited[nx][ny] = false;
            }
        }
    }

    // ㅗ 모양 계산
    static void exception_shape(int x, int y) {
        for(int i = 0; i < 4; i++) {
            int[][] exShape = exception[i]; // 4가지 모양 중 한 개씩 처리
            int res = 0;

            for(int j = 0; j<4; j++) {
                int nx = x + exShape[j][0];
                int ny = y + exShape[j][1];

                // 유효 범위 체크
                if(!checkValidation(nx, ny))
                    break;

                res += board[nx][ny];
            }
        ans = Math.max(res, ans);
        }
    }

    // 유효 범위인지 체크
    static boolean checkValidation(int x, int y) {
        if (x < 0 || y <0 || x >=N || y >= M)
            return false;
        return true;
    }
}
