package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2667 {
    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] village;
    static boolean[][] visited;
    static int N;

    // 사방탐색
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();  // 집 개수 오름차순 저장 (저장 시 자동 정렬)

        N = Integer.parseInt(br.readLine());

        village = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                village[i][j] = str.charAt(j);
            }
        }

        int villageCount = 0;   // 단지 수

        for(int i = 0; i<N; i++) {
            for(int j = 0; j<N; j++) {
                // 집이 있는 곳을 찾으면 그 장소에서 DFS 실행
                if(village[i][j] == '1' && !visited[i][j]){
                    villageCount++;
                    pq.add(dfs(new Pair(i, j)));
                }
            }
        }

        System.out.println(villageCount);   // 단지 개수 출력
        while(!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

    static int dfs(Pair p) {
        Stack<Pair> st = new Stack<>();

        st.push(p); // 스택에 삽입
        visited[p.x][p.y] = true;   // 방문 처리

        int count = 1;  // 집의 수 조사

        while(!st.isEmpty()) {
            Pair neighbor = st.pop();
            for(int k = 0; k<4;k++) {
                int nx = neighbor.x + dx[k];
                int ny = neighbor.y + dy[k];

                // 범위 내에 있고 방문하지 않은 집이라면 방문 처리
                if(checkValidation(nx, ny) && !visited[nx][ny] && village[nx][ny] == '1') {
                    visited[nx][ny] = true;
                    st.push(new Pair(nx, ny));
                    count++;    // 집 수 증가
                }
            }
        }
        return count;
    }

    // 범위 체크
    static boolean checkValidation(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}
