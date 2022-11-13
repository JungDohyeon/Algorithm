package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2606 {
    static int[][] network;
    static boolean[] visited;
    static int computer;
    static int connect;

    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        computer = Integer.parseInt(br.readLine()); // 컴퓨터 개수
        connect = Integer.parseInt(br.readLine());  // 연결 간선 수

        network = new int[computer+1][computer+1];
        visited = new boolean[computer+1];

        for(int i = 0; i < connect; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());

            network[start][dest] = 1;
            network[dest][start] = 1;
        }

        dfs(1);
    }

    static void dfs(int start) {
        Stack<Integer> st = new Stack<>();
        int count = 0;

        st.push(start);

        while(!st.isEmpty()) {
            int cur = st.pop();

            if(!visited[cur]){
                visited[cur] = true;
                count++;

                for(int i = 1; i < computer+1; i++) {
                    if(!visited[i] && network[cur][i] != 0) {
                        st.push(i);
                    }
                }
            }
        }

        // 1번 자기 자신은 제외
        System.out.println(count - 1);
    }
}
