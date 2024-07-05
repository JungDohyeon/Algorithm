
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static int N, K, W, T;
    static ArrayList<Integer>[] list;
    static int[] buildCost, costSum, buildLevel;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            buildCost = new int[N + 1];
            buildLevel = new int[N + 1];
            costSum = new int[N + 1];
            list = new ArrayList[N + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                int cost = Integer.parseInt(st.nextToken());
                buildCost[i] = cost;
                costSum[i] = cost;
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());

                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());

                list[v1].add(v2);
                buildLevel[v2]++;   // v2를 짓기 전 필요한 건물 개수
            }

            W = Integer.parseInt(br.readLine());

            topologySort();
            sb.append(costSum[W]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void topologySort() {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if(buildLevel[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next: list[cur]) {
                costSum[next] = Math.max(costSum[next], costSum[cur] + buildCost[next]);
                buildLevel[next] -= 1;

                if (buildLevel[next] == 0) {
                    q.add(next);
                }
            }
        }
    }
}
