package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ16918 {
    static int R, C, N;
    static int[][] map;
    static int cnt;

    // 동 서 남 북
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        cnt = 0;

        for(int i = 0; i < R; i++) {
            String str = br.readLine();
            for(int j = 0; j < C; j++) {
                char tmp = str.charAt(j);
                if(tmp == 'O') {
                    map[i][j] = 3;   // 폭탄인 경우 (3초마다 터지기 때문에 3초 셋팅)
                } else {
                    map[i][j] = 99;  // 폭탄이 아닌 경우 (4)
                }
            }
        }

        while(cnt < N) {
            cnt++;

            // 짝수 시간에는 나머지 칸에 모든 폭탄 심기.
            if(cnt % 2 == 1)
                Bomb();

            // 폭탄 터지는 시간 (1초 같은 경우 폭탄 시간이 3초이기 때문에 따로 처리할 필요 없다.
            else
                PlantBomb();
        }

        // print
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(map[i][j] == 99) {
                    sb.append('.');
                } else {
                    sb.append('O');
                }
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    // 폭탄 처리
    public static void Bomb() {
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                int p = map[i][j];

                // 폭탄인 경우
                if (p != 99) {
                    map[i][j] -= 1;   // 폭탄 초 감소

                    // 폭탄이고 터질 폭탄인 경우
                    if(map[i][j] == 0) {
                        Boom(i,j);
                    }
                }
            }
        }
    }

    // 폭탄 심기
    public static void PlantBomb() {
        for(int i = 0 ; i < R; i++) {
            for(int j = 0; j < C; j++) {
                int p = map[i][j];

                // 폭탄이 아닌경우 폭탄 심기
                if(p == 99) {
                    map[i][j] = 3;
                }
                // 폭탄은 시간 1초 감소
                else {
                    map[i][j] -= 1;
                }

                // 이때도 터질 폭탄이 있을 수 있기 때문에 폭탄 터짐 처리
                if (map[i][j] == 0) {
                    Boom(i, j);
                }
            }
        }
    }

    // 폭탄 터짐 처리
    static void Boom(int x, int y) {
        map[x][y] = 99;  // 폭탄 터짐 처리

        // 폭탄 폭발 범위 처리
        for(int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            // 맵을 벗어난 경우, 한번에 터지기 때문에 터질 폭탄 자리는 내비둠
            if(nx < 0 || ny < 0 || nx >= R || ny >= C || map[nx][ny] == 1)
                continue;

            // 주변 폭탄 터짐 처리
            map[nx][ny] = 99;
        }
    }
}
