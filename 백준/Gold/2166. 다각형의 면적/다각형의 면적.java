
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] dot;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dot = new int[N + 1][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            dot[i][0] = Integer.parseInt(st.nextToken());
            dot[i][1] = Integer.parseInt(st.nextToken());
        }

        dot[N][0] = dot[0][0];
        dot[N][1] = dot[0][1];

        long ans = 0;
        for (int i = 0; i < N; i++) {
            ans += (long) dot[i][0] * dot[i + 1][1] - (long) dot[i + 1][0] * dot[i][1];
        }

        System.out.printf("%.1f", (double) Math.abs(ans) / 2);
    }
}
