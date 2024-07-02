
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static class Node implements Comparable<Node> {
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

    static int N, M;
    static ArrayList<Node>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        bw.write(String.valueOf(prim(1)));
        bw.flush();
        bw.close();
    }

    private static int prim(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        int sum = 0;
        int max = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if(visited[cur.dest])
                continue;

            visited[cur.dest] = true;

            max = Math.max(max, cur.cost);
            sum += cur.cost;

            for(Node node: list[cur.dest]) {
                if (!visited[node.dest]) {
                    pq.offer(node);
                }
            }
        }

        return sum - max;
    }
}
