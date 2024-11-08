
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, ans;
    static int[][] weight;
    static boolean[] visited;
    static int startNode = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ans = Integer.MAX_VALUE;
        N = Integer.parseInt(br.readLine());
        weight = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                weight[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[0] = true;

        dfs(startNode, 0, 0);

        System.out.println(ans);
    }

    private static void dfs(int cur, int sum, int depth) {
        if (depth == N - 1) {
            if(weight[cur][startNode] != 0) {
                sum += weight[cur][startNode];
                ans = Math.min(ans, sum);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i] && weight[cur][i] > 0) {
                visited[i] = true;
                dfs(i, sum + weight[cur][i], depth + 1);
                visited[i] = false;
            }
        }
    }
}
