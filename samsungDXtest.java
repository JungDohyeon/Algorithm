// 2022 하계 Samsung DX 알고리즘 1차 문제  1번

import java.util.Scanner;

public class samsungDXtest {
    static int[][] map;
    static boolean[][] visited;
    static int[][] dir = { {0,1},{1,0},{0,-1},{-1,0} };
    static int N;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        for(int test_case = 1; test_case<=T; test_case++){
            int height = 0;
            int maxSection = 0;   // section 개수
            int max = 0;    // 가장 높은 곳
            N = sc.nextInt();
            map = new int[N][N];

            for(int i = 0; i<N; i++){
                for(int j = 0; j<N; j++){
                    map[i][j] = sc.nextInt();
                    max = Math.max(max, map[i][j]);
                }
            }

            while(height <= max) {
                int section = 0;
                visited = new boolean[N][N];
                for (int x = 0; x < N; x++) {
                    for (int y = 0; y < N; y++) {
                        if (!visited[x][y] && map[x][y] > height) {
                            section++;
                            DFS(x, y, height);
                        }
                    }
                }
                maxSection = Math.max(maxSection, section);
                height++;
            }
            sb.append("#").append(test_case).append(" ").append(maxSection).append("\n");
        }
        System.out.println(sb);
    }

    static void DFS(int x, int y, int height){
        visited[x][y] = true;
        for (int i = 0; i < dir.length; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] > height) {
                DFS(nx, ny , height);
            }
        }
    }
}
