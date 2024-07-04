
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int K, V, E;
    static ArrayList<Integer>[] graph;
    static int[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        K = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < K; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            visited = new int[V + 1];

            graph = new  ArrayList[V + 1];
            for (int i = 0; i <= V; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());

                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                graph[start].add(end);
                graph[end].add(start);
            }

            sb.append(solution() ? "YES" : "NO").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }


    private static boolean solution() {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= V; i++) {
            if(visited[i] > 0)
                continue;

            q.add(i);
            visited[i] = 1;

            while (!q.isEmpty()) {
                int cur = q.poll();

                for (int next: graph[cur]) {
                    if (visited[next] == visited[cur]) {
                        return false;
                    }

                    if (visited[next] == 0) {
                        q.add(next);
                        visited[next] = visited[cur] == 1 ? 2 : 1;
                    }
                }
            }
        }

        return true;
    }
}
