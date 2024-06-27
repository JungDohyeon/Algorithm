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
        int time;

        public Node(int dest, int time) {
            this.dest = dest;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }

    static int N, M, X;
    static int[] dist, reverseDist;
    static ArrayList<Node>[] pureGraph, reverseGraph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        reverseDist = new int[N + 1];
        pureGraph = new ArrayList[N + 1];
        reverseGraph = new ArrayList[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(reverseDist, Integer.MAX_VALUE);

        for (int i = 0; i <= N; i++) {
            pureGraph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            pureGraph[start].add(new Node(dest, time));
            reverseGraph[dest].add(new Node(start, time));
        }

        dijkstra(pureGraph, dist, X);
        dijkstra(reverseGraph, reverseDist, X);

        int ans = 0;

        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, dist[i] + reverseDist[i]);
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }

    public static void dijkstra(ArrayList<Node>[] list, int[] dist, int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            for (Node next: list[cur.dest]) {
                if(dist[next.dest] > dist[cur.dest] + next.time) {
                    dist[next.dest] = dist[cur.dest] + next.time;
                    pq.add(new Node(next.dest, dist[next.dest]));
                }
            }
        }
    }
}
