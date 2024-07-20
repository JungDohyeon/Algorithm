
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][4];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] ab = new int[N * N];
        int[] cd = new int[N * N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ab[i * N + j] = arr[i][0] + arr[j][1];
                cd[i * N + j] = arr[i][2] + arr[j][3];
            }
        }

        Arrays.sort(ab);
        Arrays.sort(cd);

        int pointer_1 = 0;
        int pointer_2 = N*N - 1;

        long answer = 0;

        while(pointer_1 < N*N && pointer_2 > -1) {
            long v1 = ab[pointer_1];
            long v2 = cd[pointer_2];

            long tmp = v1 + v2;

            if (tmp == 0) {
                long c1 = 0;
                long c2 = 0;

                while(pointer_1 < N*N && v1 == ab[pointer_1]) {
                    pointer_1++;
                    c1++;
                }

                while(pointer_2 > -1 && v2 == cd[pointer_2]) {
                    pointer_2--;
                    c2++;
                }

                answer += c1 * c2;
            } else if (tmp > 0) {
                pointer_2--;
            } else {
                pointer_1++;
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}