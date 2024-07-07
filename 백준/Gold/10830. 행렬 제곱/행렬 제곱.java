
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    final static int MOD = 1000;
    static int N;
    static long B;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++)
                arr[i][j] = Integer.parseInt(st.nextToken()) % MOD;
        }

        int[][] res = arrPow(arr, B);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(res[i][j]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int[][] arrPow(int[][] origin, long exp) {
        if (exp == 1L)
            return origin;

        int[][] tmp = arrPow(origin, exp >> 1);

        tmp = arrMul(tmp, tmp);

        if(exp % 2 == 1L)
            tmp = arrMul(tmp, origin);

        return tmp;
    }

    static int[][] arrMul(int[][] arr1, int[][] arr2) {
        int[][] result = new int[N][N];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                for (int k = 0; k < N; k++) {
                    result[i][j] += arr1[i][k] * arr2[k][j];
                    result[i][j] %= MOD;
                }

        return result;
    }
}
