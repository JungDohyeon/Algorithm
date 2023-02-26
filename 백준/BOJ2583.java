package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2583 {
    static int M, N, K;
    static int[][] map;

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        int area = 0;

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int leftX = Integer.parseInt(st.nextToken());
            int leftY = Integer.parseInt(st.nextToken());
            int rightX = Integer.parseInt(st.nextToken());
            int rightY = Integer.parseInt(st.nextToken());

            for(int j = leftY; j < rightY; j++){
                for(int l = leftX; l < rightX; l++) {
                    map[M - 1 - j][l] = 1;
                }
            }
        }

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 0) {
                    area++;
                    sb.append(DFS(i, j)).append(" ");
                }
            }
        }

        st = new StringTokenizer(sb.toString());
        int[] arr = new int[area];

        for(int i = 0; i < area; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        System.out.println(area);
        for(int i = 0; i < area; i++) {
            System.out.print(arr[i] + " ");
        }
    }


    static int DFS(int x, int y) {
        int size = 1;
        map[x][y] = 99;    // 방문처리
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(x, y));

        while(!st.isEmpty()) {
            Pair p = st.pop();

            for(int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                // 범위 밖, 이미 방문 점 처리
                if(nx < 0 || ny < 0 || nx >= M || ny >= N || map[nx][ny] != 0)
                    continue;

                size++;
                st.push(new Pair(nx, ny));
                map[nx][ny] = 99;
            }
        }

        return size;
    }
}
