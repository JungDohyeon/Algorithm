
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M, answer;
    static int[][] map;
    static ArrayList<Point> house;
    static ArrayList<Point> chicken;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        house = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) {
                    house.add(new Point(i, j));
                } else if (map[i][j] == 2) {
                    chicken.add(new Point(i, j));
                }
            }
        }

        visited = new boolean[chicken.size()];

        answer = Integer.MAX_VALUE;
        dfs(0, 0);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    private static void dfs(int idx, int select) {
        if (select == M) {
            int res = 0;

            for (Point point : house) {
                int tmp = Integer.MAX_VALUE;

                for (int j = 0; j < chicken.size(); j++) {
                    // 선택한 치킨 집과 집의 거리
                    if (visited[j]) {
                        int dist = Math.abs(point.x - chicken.get(j).x) + Math.abs(point.y - chicken.get(j).y);
                        tmp = Math.min(tmp, dist);
                    }
                }

                res += tmp;
            }

            answer = Math.min(answer, res);
        }

        // backtracking
        for (int i = idx; i < chicken.size(); i++) {
            visited[i] = true;
            dfs(i + 1, select + 1);
            visited[i] = false;
        }
    }
}

