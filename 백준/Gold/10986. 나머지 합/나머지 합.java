import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    static long res = 0;
    static long[] sumArr, remainIdx;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sumArr = new long[N + 1];
        remainIdx = new long[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            // 누적합을 M으로 나눈 나머지 저장
            sumArr[i] = (sumArr[i - 1] + Integer.parseInt(st.nextToken())) % M;

            // M으로 나눠지는 경우
            if(sumArr[i] == 0) {
                res++;
            }

            remainIdx[(int) sumArr[i]]++;
        }

        for(int i = 0; i < M; i++) {
            if(1 < remainIdx[i]) {
                res += ((remainIdx[i] * (remainIdx[i] - 1)) >> 1);
            }
        }

        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
        br.close();
    }
}