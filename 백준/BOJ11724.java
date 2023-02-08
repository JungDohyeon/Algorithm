package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ11724 {
    static int N, M;    // 정점, 간선 개수
    static int[][] graph;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N+1][N+1];
        visited = new boolean[N+1];
        answer = 0;

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());

            // 간선 입력 (무향 그래프이므로 양방향 적용)
            graph[start][dest] = 1;
            graph[dest][start] = 1;
        }

        // 홀로있는 정점을 파악하기 위해
        for(int i = 1; i <= N; i++) {
            graph[i][i] = 1;
        }

        // 연결 요소 탐색 시작 (무향 그래프이므로 배열을 대각선으로 잘라서 둘 중 한 곳만 탐색해도 된다.
        for(int i = 1; i <= N; i++) {
            for(int j = i; j <= N; j++) {
                // 방문하지 않고 그래프가 연결되어 있다면
                if(!visited[i] && graph[i][j] == 1) {
                    Search(i, j);
                }
            }
        }

        System.out.println(answer);
    }

    // dfs
    static void Search(int start, int dest) {
        answer++;

        // 해당 간선 방문 처리
        visited[start] = true;
        visited[dest] = true;

        Stack<Integer> st = new Stack<>();
        st.push(dest);

        while(!st.isEmpty()){
            int tmp = st.pop();

            for(int i = 1; i <= N; i++) {
                if(graph[tmp][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    st.push(i);
                }
            }
        }
    }
}
