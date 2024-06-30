
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static class Node {
        int dest;
        int cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    static final int INF = 987654321;

    static int TC, N, M, W;
    static int[] dist;
    static ArrayList<Node>[] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        TC = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            dist = new int[N + 1];
            map = new ArrayList[N + 1];

            Arrays.fill(dist, INF);
            dist[1] = 0;

            for (int i = 0; i <= N; i++) {
                map[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int start = Integer.parseInt(st.nextToken());
                int dest = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                map[start].add(new Node(dest, cost));
                map[dest].add(new Node(start, cost));
            }

            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());

                int start = Integer.parseInt(st.nextToken());
                int dest = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                map[start].add(new Node(dest, -cost));
            }

            sb.append(bellmanFord() ? "YES" : "NO").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static boolean bellmanFord() {
        boolean isUpdate = false;

        for (int i = 1; i < N; i++) {
            isUpdate = false;

            for (int j = 1; j <= N; j++) {
                for(Node node: map[j]) {
                    if(dist[node.dest] > dist[j] + node.cost) {
                        dist[node.dest] = dist[j] + node.cost;
                        isUpdate = true;
                    }
                }
            }

            if (!isUpdate) {
                break;
            }
        }

        // N번째 실행 시 업데이트가 일어난다면 음수 사이클 존재
        if (isUpdate) {
            for (int i = 1; i <= N; i++) {
                for (Node node: map[i]) {
                    if (dist[node.dest] > dist[i] + node.cost) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
