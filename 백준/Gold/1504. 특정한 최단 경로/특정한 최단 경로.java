
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int num, weight;

        public Node(int num, int weight){
            this.num = num;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    final static int INF = 200000000;
    static int N, E;
    static List<Node>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(dest, weight));
            graph[dest].add(new Node(start, weight));
        }

        st = new StringTokenizer(br.readLine());

        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int cost1 = 0; // v1 -> v2 -> N
        int cost2 = 0; // v2 -> v1 -> N
        
        cost1 += dijkstra(1, v1);
        cost1 += dijkstra(v1, v2);
        cost1 += dijkstra(v2, N);
        
        cost2 += dijkstra(1, v2);
        cost2 += dijkstra(v2, v1);
        cost2 += dijkstra(v1, N);
        
        int ans = cost1 >= INF && cost2 >= INF ? - 1 : Math.min(cost1, cost2);
                
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }

    private static int dijkstra(int start, int dest) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        int[] dist = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            dist[i] = INF;
        }

        pq.add(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Node n = pq.poll();

            if (dist[n.num] < n.weight) {
                continue;
            }

            for(Node next: graph[n.num]) {
                int nextWeight = n.weight + next.weight;
                
                if (nextWeight < dist[next.num]) {
                    dist[next.num] = nextWeight;
                    pq.add(new Node(next.num, nextWeight));
                }
            }
        }
        
        return dist[dest];
    }
}
