
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] maxdp;
    static int[] mindp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        maxdp = new int[3];
        mindp = new int[3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int v3 = Integer.parseInt(st.nextToken());

            if (i == 0) {
                maxdp[0] = mindp[0] = v1;
                maxdp[1] = mindp[1] = v2;
                maxdp[2] = mindp[2] = v3;

            } else {
                int beforeMax_1 = maxdp[1];
                int beforeMin_1 = mindp[1];

                maxdp[1] = Math.max(Math.max(maxdp[0], maxdp[1]), maxdp[2]) + v2;
                mindp[1] = Math.min(Math.min(mindp[0], mindp[1]), mindp[2]) + v2;

                maxdp[0] = Math.max(maxdp[0], beforeMax_1) + v1;
                mindp[0] = Math.min(mindp[0], beforeMin_1) + v1;

                maxdp[2] = Math.max(beforeMax_1, maxdp[2]) + v3;
                mindp[2] = Math.min(beforeMin_1, mindp[2]) + v3;
            }
        }

        bw.write(Math.max(Math.max(maxdp[0], maxdp[1]), maxdp[2]) + " ");
        bw.write(String.valueOf(Math.min(Math.min(mindp[0], mindp[1]), mindp[2])));
        bw.flush();
        bw.close();
    }
}
