
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static StringBuilder res = new StringBuilder();
    static HashSet<String> set = new HashSet<>();
    static int[] input;
    static int[] num;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        input = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);

        num = new int[M];
        dfs(0);

        bw.write(res.toString());
        bw.flush();
        bw.close();
    }

    private static void dfs(int depth) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();

            for (int n: num) {
                sb.append(n).append(' ');
            }
            sb.append("\n");

            String str = sb.toString();

            if (!set.contains(str)) {
                set.add(str);
                res.append(str);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                num[depth] = input[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
