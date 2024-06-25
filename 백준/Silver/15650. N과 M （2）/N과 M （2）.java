import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        dfs(1, 0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void dfs(int idx, int depth) {
        if (depth == M) {
            for (int num: arr) {
                sb.append(num).append(" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = idx; i <= N; i++) {
            arr[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }
}
