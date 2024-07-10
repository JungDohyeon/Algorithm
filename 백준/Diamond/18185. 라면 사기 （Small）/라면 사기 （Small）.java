import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] ramen;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        ramen = new int[N + 2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ramen[i] = Integer.parseInt(st.nextToken());
        }

        int idx = 0;
        int cost = 0;

        while(idx < N) {
            // 구매할 라면이 있다면
            if (ramen[idx] > 0) {
                int remain = ramen[idx];
                cost += 3 * remain;     // 3원 비용을 통해 구매
                ramen[idx] = 0;

                remain = Math.min(remain, ramen[idx + 1]);   // i + 1 라면과 연계하여 구매 가능한 최대 개수
                cost += 2 * remain;
                ramen[idx + 1] -= remain;   // i + 1 구매 완료

                remain = Math.min(remain, ramen[idx + 2] - Math.min(ramen[idx + 1], ramen[idx + 2]));   // i + 2 라면과 연계
                cost += 2 * remain;
                ramen[idx + 2] -= remain;   // i + 2 구매 완료
            }

            idx++;
        }

        bw.write(String.valueOf(cost));
        bw.close();
        br.close();
    }
}