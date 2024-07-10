import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static long B, C;
    static long[] ramen;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        ramen = new long[N + 2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ramen[i] = Long.parseLong(st.nextToken());
        }

        long cost = 0;

        if (B <= C) {
            for (int i = 0; i < N; i++) {
                cost += B * ramen[i];
            }
        } else {
            int idx = 0;

            while(idx < N) {
                // 구매할 라면이 있다면
                if (ramen[idx] > 0) {
                    long remain = ramen[idx];
                    cost += B * remain;     // B원 비용을 통해 구매
                    ramen[idx] = 0;

                    remain = Math.min(remain, ramen[idx + 1]);   // i + 1 라면과 연계하여 구매 가능한 최대 개수
                    cost += C * remain;
                    ramen[idx + 1] -= remain;   // i + 1 구매 완료

                    remain = Math.min(remain, ramen[idx + 2] - Math.min(ramen[idx + 1], ramen[idx + 2]));   // i + 2 라면과 연계
                    cost += C * remain;
                    ramen[idx + 2] -= remain;   // i + 2 구매 완료
                }

                idx++;
            }
        }

        bw.write(String.valueOf(cost));
        bw.close();
        br.close();
    }
}