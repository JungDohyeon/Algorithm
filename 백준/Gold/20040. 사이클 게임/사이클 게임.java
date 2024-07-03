
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parents = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }

        int ans = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            if(!union(v1, v2)) {
                ans = i + 1;
                break;
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }

    private static boolean union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        // 사이클 형성
        if (parentA == parentB)
            return false;

        parents[parentB] = parentA;
        return true;
    }

    private static int find(int n) {
        if (n == parents[n])
            return n;

        return find(parents[n]);
    }
}
