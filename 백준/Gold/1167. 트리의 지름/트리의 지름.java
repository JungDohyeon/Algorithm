import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static class Node {
        int num;
        int cost;

        public Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
    }

    static int V;
    static int max, farNode;
    static ArrayList<Node>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        V = Integer.parseInt(br.readLine());
        visited = new boolean[V + 1];
        list = new ArrayList[V + 1];

        for (int i = 0; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());

            while(true) {
                int next = Integer.parseInt(st.nextToken());

                if (next == -1)
                    break;

                int weight = Integer.parseInt(st.nextToken());
                list[start].add(new Node(next, weight));
            }
        }

        dfs(1, 0);

        visited = new boolean[V + 1];
        dfs(farNode, 0);

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }

    private static void dfs(int num, int weight) {
        if (weight > max) {
            max = weight;
            farNode = num;
        }

        visited[num] = true;

        for (Node next: list[num]) {
            if(!visited[next.num]) {
                visited[next.num] = true;
                dfs(next.num, next.cost + weight);
            }
        }
    }
}
