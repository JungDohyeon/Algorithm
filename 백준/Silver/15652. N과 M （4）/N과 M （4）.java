import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static int[] num;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[M];

        dfs(1, 0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void dfs(int idx, int depth) {
        if (depth == M) {
            for (int n: num) {
                sb.append(n).append(' ');
            }
            sb.append("\n");
            return;
        }

        for (int i = idx; i <= N; i++) {
            num[depth] = i;
            dfs(i, depth + 1);
        }
    }
}
