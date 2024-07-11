
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    final static int[] dx = {0, 0, 1, -1};
    final static int[] dy = {1, -1, 0, 0};

    static int R, C, T;
    static int[][] map;
    static int airCleaner = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (airCleaner == -1 && map[i][j] == -1) {
                    airCleaner = i;
                }
            }
        }

        for (int i = 0; i < T; i++) {
            map = dust();
            airOperator();
        }

        int ans = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) {
                    ans += map[i][j];
                }
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }

    static private int[][] dust() {
        int[][] newMap = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == -1) {
                    newMap[i][j] = -1;
                    continue;
                }

                newMap[i][j] += map[i][j];
                int dustValue = map[i][j] / 5;

                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx < 0 || ny < 0 || nx >= R || ny >= C)
                        continue;

                    if (map[nx][ny] == -1)
                        continue;

                    newMap[nx][ny] += dustValue;
                    newMap[i][j] -= dustValue;
                }
            }
        }

        return newMap;
    }

    private static void airOperator() {
        int top = airCleaner;
        int down = airCleaner + 1;

        for (int i = top - 1; i > 0; i--)
            map[i][0] = map[i-1][0];
        for (int i = 0; i < C - 1; i++)
            map[0][i] = map[0][i+1];
        for (int i = 0; i < top; i++)
            map[i][C - 1] = map[i + 1][C - 1];
        for (int i = C - 1; i > 1; i--)
            map[top][i] = map[top][i-1];
        map[top][1] = 0;

        for (int i = down + 1; i < R - 1; i++)
            map[i][0] = map[i + 1][0];
        for (int i = 0; i < C - 1; i++)
            map[R - 1][i] = map[R - 1][i + 1];
        for (int i = R - 1; i > down; i--)
            map[i][C - 1] = map[i - 1][C - 1];
        for (int i = C - 1; i > 1; i--)
            map[down][i] = map[down][i - 1];
        map[down][1] = 0;
    }
}