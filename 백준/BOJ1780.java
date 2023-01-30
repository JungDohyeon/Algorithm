package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1780 {
    static int[][] board;   // board
    static int N;   // size

    static int zero;    // 0 개수
    static int plus;    // 1 개수
    static int minus;   // -1 개수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // Initialize
        zero = 0;
        plus = 0;
        minus = 0;

        divide(0, 0, N);

        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
    }

    static void divide(int startX, int startY, int size) {
        int n = valid(startX, startY, size);

        if (n != 99) {
            if (n == 1)
                plus++;
            else if (n == 0)
                zero++;
            else
                minus++;
            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                divide(startX + size/3 * i, startY + size/3 * j, size / 3);
            }
        }
    }


    static int valid(int x, int y, int size) {
        int tmp = board[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (board[i][j] != tmp) {
                    return 99;  // 사실상 false 의미
                }
            }
        }

        return tmp; // 다 같으면 tmp 값으로 리턴
    }
}
