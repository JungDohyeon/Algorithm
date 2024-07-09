
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int N;
    static char[][] star;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        star = new char[N][2 * N - 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2*N-1; j++) {
                star[i][j] = ' ';
            }
        }

        draw(0, N - 1, N);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2*N-1; j++)
                sb.append(star[i][j]);
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void draw(int x, int y, int n) {
        if (n == 3) {
            star[x][y] = '*';   // 맨 위
            star[x + 1][y - 1] = star[x + 1][y + 1] = '*';  // 가운데
            star[x + 2][y - 2] = star[x + 2][y - 1] = star[x + 2][y] = star[x + 2][y + 1] = star[x + 2][y + 2] = '*';   // 맨 밑
            return;
        }

        int half = n >> 1;

        draw(x, y, half);
        draw(x + half, y - half, half);
        draw(x + half, y + half, half);
    }
}

