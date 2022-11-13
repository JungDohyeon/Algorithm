package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2468 {
    static class Pair{
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static int MAX_H;   // 주어진 정보의 최대 높이
    static int safe_region;
    static int[][] map;
    static boolean[][] visited;

    // 사방탐색
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 맵 크기
        N = Integer.parseInt(br.readLine());
        MAX_H = 0;
        map = new int[N][N];
        safe_region = 1;    // 0인 경우는 1이기 때문에 1로 초기화

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                map[i][j] = tmp;
                if(tmp > MAX_H)
                    MAX_H = tmp;
            }
        }

        // 0인 경우는 1이므로 그냥 스킵, 최대 높이라면 다 잠기기 때문에 최대 높이도 스킵
        for (int height = 1; height < MAX_H; height++) {
            // 높이 마다 초기화 시킨다.
            visited = new boolean[N][N];
            int ans = 0;
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {
                    if(map[j][k] > height && !visited[j][k]) {
                        ans++;
                        dfs(j, k ,height);
                    }
                }
            }

            if(ans > safe_region) {
                safe_region = ans;
            }
        }

        System.out.println(safe_region);
    }

    static void dfs(int x, int y, int h) {
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(x, y));
        visited[x][y] = true;

        while(!st.isEmpty()) {
            Pair next = st.pop();

            for(int k = 0; k<4; k++) {
                int nx = next.x + dx[k];
                int ny = next.y + dy[k];

                if(checkValidation(nx, ny) && !visited[nx][ny] && map[nx][ny] > h) {
                    st.push(new Pair(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }

    // 범위 체크
    static boolean checkValidation(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}
