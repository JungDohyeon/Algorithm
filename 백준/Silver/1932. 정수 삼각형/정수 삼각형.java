import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] triangle;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        triangle = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < i + 1; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    triangle[i][j] += triangle[i - 1][j];
                } else if (j == i) {
                    triangle[i][j] += triangle[i - 1][j - 1];
                } else {
                    triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
                }
            }
        }

        int answer = 0;

        for (int value: triangle[N - 1]) {
            answer = Math.max(value, answer);
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
