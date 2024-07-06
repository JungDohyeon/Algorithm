
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static class Node implements Comparable<Node> {
        int dest;
        int cost;

        public Node (int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int N, M, R, T;
    static ArrayList<Node>[] list;
    static int[] value;
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        value = new int[N + 1];
        dist = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            value[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[v1].add(new Node(v2, cost));
            list[v2].add(new Node(v1, cost));
        }

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, dijkstra(i));
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }

    public static int dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(dist, Integer.MAX_VALUE);
        visited = new boolean[N + 1];

        pq.add(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            for (Node next: list[cur.dest]) {
                if(!visited[next.dest] && dist[next.dest] > dist[cur.dest] + next.cost) {
                    dist[next.dest] = dist[cur.dest] + next.cost;
                    pq.add(new Node(next.dest, dist[next.dest]));
                }
            }
        }

        int items = 0;

        for (int i = 1; i <= N; i++) {
            if(dist[i] <= M)
                items += value[i];
        }

        return items;
    }
}
