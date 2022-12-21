package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1697 {
    static int N, K;
    static boolean[] visited;

    static class Pair {
        int dist;
        int cnt;

        public Pair(int dist, int cnt) {
            this.dist = dist;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];

        BFS(N);
    }

    public static void BFS (int n) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(n, 0));

        while(!q.isEmpty()) {
            Pair p = q.poll();

            if(p.dist == K) {
                System.out.println(p.cnt);
                break;
            }

            int mult = p.dist*2;
            int add = p.dist + 1;
            int sub = p.dist - 1;

            if(mult >= 0 && mult < 100001) {
                if (!visited[mult]){
                    q.add(new Pair(mult, p.cnt + 1));
                    visited[mult] = true;
                }
            }

            if(add >= 0 && add < 100001) {
                if (!visited[add]){
                    q.add(new Pair(add, p.cnt + 1));
                    visited[add] = true;
                }
            }

            if(sub >= 0 && sub < 100001) {
                if (!visited[sub]){
                    q.add(new Pair(sub, p.cnt + 1));
                    visited[sub] = true;
                }
            }
        }


    }
}
