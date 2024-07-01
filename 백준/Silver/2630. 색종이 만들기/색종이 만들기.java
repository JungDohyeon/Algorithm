
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] paper;
    static int white, blue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        white = 0;
        blue = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, N);

        sb.append(white).append("\n");
        sb.append(blue).append("\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void divide(int x, int y, int n) {
        boolean flag = true;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(paper[x][y] != paper[x + i][y + j]) {
                    flag = false;
                    break;
                }
            }
        }

        if (flag) {
            if(paper[x][y] == 0) {
                white++;
            }else {
                blue++;
            }
        } else {
            int half = n >> 1;

            divide(x, y, half);
            divide(x + half, y, half);
            divide(x, y + half, half);
            divide(x + half, y + half, half);
        }
    }
}
