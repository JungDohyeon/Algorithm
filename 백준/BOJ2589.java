package 백준;

// 보물섬
// 거리 -> BFS 생각
// 모든 육지에서 BFS를 돌려 max값 리턴

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2589 {

    // 좌표 클래스 (좌표, 거리)
    static class Pair{
        int x, y, len;

        public Pair(int x, int y, int len) {
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }

    static char[][] map;
    static boolean[][] visited;
    static int N, M, answer;

    // 사방탐색
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];   // 지도 생성

        answer = 0;

        // map 정보 넣기
        for(int i = 0; i<N; i++) {
            String str = br.readLine();
            for(int j = 0; j<M; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        // 탐색 시작
        for(int i = 0; i<N; i++) {
            for(int j = 0; j<M; j++) {
                // 육지인경우
                if(map[i][j] == 'L') {
                    visited = new boolean[N][M];    // 방문 정보 확인
                    bfs(new Pair(i, j, 0));
                }
            }
        }
        System.out.println(answer);
    }

    static void bfs(Pair p) {
        Queue<Pair> q = new LinkedList<>();
        q.add(p);
        visited[p.x][p.y] = true;

        while(!q.isEmpty()) {
            Pair nextP = q.poll();
            for(int k = 0; k < 4; k++) {
                int nx = nextP.x + dx[k];
                int ny = nextP.y + dy[k];

                // 범위 안에 있으며 방문하지않고 육지인 경우
                if(validationCheck(nx, ny) && !visited[nx][ny] && map[nx][ny] == 'L') {
                    visited[nx][ny] = true;
                    q.add(new Pair(nx, ny, nextP.len + 1));
                    answer = Math.max(answer, nextP.len + 1);
                }
            }
        }
    }

    // 범위안에 있는지 체크
    static boolean validationCheck(int x, int y) {
        if(x < 0 || x >= N || y < 0 || y >= M) {
            return false;
        }
        return true;
    }
}
