package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ5014 {
    static int F, S, G, U, D;
    static boolean[] visited;
    static int[] move;
    static int[] dest;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());   // 현재 위치
        G = Integer.parseInt(st.nextToken());   // 목적지
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visited = new boolean[F+1];
        dest = new int[F+1];

        move = new int[2];  // 위, 아래 움직이는 칸 수
        move[0] = U;
        move[1] = -D;

        int res = bfs(S);
        System.out.println(res == -1 ? "use the stairs" : res);
    }

    static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int next = q.poll();

            // 도착 시 반복 종료
            if (next == G) {
                return dest[G];
            }

            // 위로 올라가거나 아래로 내려가거나
            for(int k = 0; k<2; k++) {
                int nextFloor = next + move[k];
                if(0 < nextFloor && nextFloor <= F && !visited[nextFloor]) {
                    q.add(nextFloor);
                    visited[nextFloor] = true;
                    dest[nextFloor] = dest[next] + 1;
                }
            }
        }
        return -1;
    }
}
