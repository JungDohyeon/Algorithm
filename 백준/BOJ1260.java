package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1260 {
    static int[][] graph;
    static boolean[] visited;
    static int N, M, startPoint;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " " );
        N = Integer.parseInt(st.nextToken());   // 정점
        M = Integer.parseInt(st.nextToken());   // 간선
        startPoint = Integer.parseInt(st.nextToken());  // 시작 점

        graph = new int[N+1][N+1];  // 그래프 저장소 생성

        for(int i = 0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());

            graph[start][dest] = 1;
            graph[dest][start] = 1; // 양방향 간선이므로 반대편도 처리
        }

        // dfs
        visited = new boolean[N+1];    // 방문 확인
        dfs(startPoint);

        System.out.println();

        // bfs
        visited = new boolean[N+1];    // 방문 확인
        bfs(startPoint);

    }

    // dfs 탐색
    static void dfs(int s) {
        int[] stack = new int[N*N];   // stackoverflow 방지를 위해 크기를 크게 잡음
        int top = -1;

        stack[++top] = s;

        while(top != -1) {
            int cur = stack[top--];     // stack 에서 추출

            if(!visited[cur]) {
                System.out.print(cur + " ");
                visited[cur] = true;    // 방문 표기

                // 정점 번호가 작은 것을 먼저 방문하기 때문에 작은 것이 맨 위에 오도록 큰 정점부터 탐색 시작 (LIFO)
                for(int nextSpot = N; nextSpot > 0; nextSpot--) {
                    // 방문하지 않았고 존재하는 간선이라면 스택에 삽입
                    if(!visited[nextSpot] && graph[cur][nextSpot] != 0)
                        stack[++top] = nextSpot;
                }
            }
        }
    }

    // bfs 탐색
    static void bfs(int s) {
        int[] q = new int[N*N] ;
        int front = -1;
        int rear = -1;

        q[++rear] = s;

        while(front != rear) {
            int cur = q[++front];

            if(!visited[cur]) {
                System.out.print(cur + " ");
                visited[cur] = true;

                // 작은 값부터 탐색이므로 큐에 작은 값 부터 삽입 (FIFO)
                for(int nextSpot = 1; nextSpot < N + 1; nextSpot++) {
                    // 방문하지 않았거나 간선이 존재하면 큐에 삽입
                    if(!visited[nextSpot] && graph[cur][nextSpot] != 0)
                        q[++rear] = nextSpot;
                }
            }
        }
    }
}
