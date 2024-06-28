
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node>{
        int dest;
        int cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int V, E, K;
    static int[] dist;
    static boolean[] visited;
    static ArrayList<Node>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        graph = new ArrayList[V];
        dist = new int[V];
        visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            graph[v1 - 1].add(new Node(v2 - 1, value));
        }

        dijkstra(K - 1);

        for (int value: dist) {
            sb.append(value == Integer.MAX_VALUE ? "INF" : value).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
           Node cur = pq.poll();
           visited[cur.dest] = true;

           for(Node next: graph[cur.dest]) {
               if (!visited[next.dest] && dist[next.dest] > dist[cur.dest] + next.cost) {
                   dist[next.dest] = dist[cur.dest] + next.cost;
                   pq.add(new Node(next.dest, dist[next.dest]));
               }
           }
        }
    }
}
