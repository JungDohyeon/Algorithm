import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static final int INF = 99999999;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        map = new int[V][V];

        for(int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i != j)
                    map[i][j] = INF;
            }
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            map[start - 1][dest - 1] = weight;
        }

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                if (i == k)
                    continue;

                for (int j = 0; j < V; j++) {
                    if (i == j || k == j)
                        continue;

                    map[i][j] = Math.min(map[i][j], map[i][k] +  map[k][j]);
                }
            }
        }

        int answer = INF;

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i != j && map[i][j] != INF && map[j][i] != INF) {
                    answer = Math.min(answer, map[i][j] + map[j][i]);
                }
            }
        }

        System.out.println(answer == INF ? -1 : answer);
    }
}
