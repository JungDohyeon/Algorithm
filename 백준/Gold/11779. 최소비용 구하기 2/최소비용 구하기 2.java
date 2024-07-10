import java.io.*;
import java.util.*;

public class Main {

    private static class Node implements Comparable<Node> {
        int dest;
        int value;

        public Node (int dest, int value) {
            this.dest = dest;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }

    static int N, M;
    static ArrayList<Node>[] list;
    static int[] dist, preNode;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new ArrayList[N + 1];
        dist = new int[N + 1];
        preNode = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            list[start].add(new Node(dest, value));
        }

        st = new StringTokenizer(br.readLine());
        int target_s = Integer.parseInt(st.nextToken());
        int target_d = Integer.parseInt(st.nextToken());

        dijkstra(target_s);
        sb.append(dist[target_d]).append("\n");

        int tmp = target_d;
        int cnt = 1;

        Stack<Integer> stack = new Stack<>();
        stack.push(target_d);
        while(preNode[tmp] != 0) {
            cnt++;
            stack.push(preNode[tmp]);
            tmp = preNode[tmp];
        }

        sb.append(cnt).append("\n");
        while(!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if(visited[cur.dest])
                continue;

            visited[cur.dest] = true;

            for(Node next: list[cur.dest]) {
                if (dist[next.dest] > dist[cur.dest] + next.value) {
                    dist[next.dest] = dist[cur.dest] + next.value;
                    preNode[next.dest] = cur.dest;
                    pq.add(new Node(next.dest, dist[next.dest]));
                }
            }
        }
    }
}