package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7576 {

    static class Tomato{
        int x, y, days;

        public Tomato(int x, int y, int days) {
            this.x = x;
            this.y = y;
            this.days = days;
        }
    }

    // 사방탐색
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static int M, N;
    static int[][] tomato;
    static int zeroTomato;  // 안익은 토마토 개수
    static int ans;

    static Queue<Tomato> q;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        q = new LinkedList<>();

        M = Integer.parseInt(st.nextToken());   // 가로 칸
        N = Integer.parseInt(st.nextToken());   // 세로 칸

        tomato = new int[N][M];
        zeroTomato = 0;     // 안익은 토마토 개수 판별
        ans = 0;

        for(int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j<M; j++) {
                int state = Integer.parseInt(st.nextToken());
                tomato[i][j] = state;

                // 익었으면 큐에 삽입
                if(state == 1)
                    q.offer(new Tomato(i, j, 0));

                // 안 익은 토마토 개수 카운트
                if(state == 0)
                    zeroTomato++;
            }
        }

        bfs();

        if(zeroTomato != 0) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }

    }

    static void bfs() {
        while (!q.isEmpty()) {
            Tomato next = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = next.x + dx[i];
                int ny = next.y + dy[i];

                if(checkValidation(nx, ny) && tomato[nx][ny] == 0) {
                    tomato[nx][ny] = 1; // 인접 토마토 익음
                    zeroTomato--;   // 안익었던 것 익게 했으므로 1 감소
                    q.offer(new Tomato(nx, ny, next.days + 1));
                    ans = next.days + 1;
                }
            }
        }
    }

    // 범위 체크
    static boolean checkValidation(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}
