
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] in, inIdx, post;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        in = new int[N];
        inIdx = new int[N + 1];
        post = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            in[i] = Integer.parseInt(st.nextToken());
            inIdx[in[i]] = i;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            post[i] = Integer.parseInt(st.nextToken());
        }

        solution(0, N - 1, 0, N - 1);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void solution(int in_start, int in_end, int post_start, int post_end) {
        if (in_start > in_end || post_start > post_end)
            return;

        int root = post[post_end];
        sb.append(root).append(" ");

        int rootIdx = inIdx[root];

        solution(in_start, rootIdx - 1, post_start, post_start + rootIdx - in_start - 1);
        solution(rootIdx + 1, in_end, post_start + rootIdx - in_start, post_end - 1);
    }
}
