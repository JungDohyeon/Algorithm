package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14503 {
    static int N, M;
    static int[][] map;

    // 순서대로 북, 동, 남, 서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int cnt; // 청소 칸

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());   // 방향

        cnt = 1;    // 초기 자로 청소 == 1

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean(r, c, d);
        System.out.println(cnt);
    }

    // dfs
    static void clean(int r, int c, int d) {
        map[r][c] = -1; // -1은 청소를 한 부분을 나타낸다.

        for(int i = 0; i < 4; i++) {
            d = (d + 3) % 4;   // 현 방향 기준 왼쪽부터 탐색

            // 새 탐색 좌표
            int nx = r + dx[d];
            int ny = c + dy[d];

            // 청소할 수 있는 공간이면 청소
            if(nx < N && ny < M && nx >= 0 && ny >= 0 && map[nx][ny] == 0) {
                cnt++;
                clean(nx, ny, d);

                return;
            }
        }

        // 여기까지 왔다는 것은 4방향 모두 청소를 못한다는 뜻 (벽이거나 이미 청소했거나)
        int backIdx = (d + 2) % 4;
        int backX = r + dx[backIdx];
        int backY = c + dy[backIdx];

        // 뒤가 벽이 아니라면 후진해서 다시 탐색.
        if(backX >= 0 && backY >= 0 && backX < N && backY < M && map[backX][backY] != 1) {
            clean(backX, backY, d);
        }
    }
}
