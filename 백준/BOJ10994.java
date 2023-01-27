package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ10994 {
    static char[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        N = 4*N -  3;   // board 넓이

        board = new char[N][N];

        recur(0, N);

        for(int i = 0; i < N; i++) {
            for(int j = 0; j< N; j++) {
                if(board[i][j] != '*')
                    System.out.print(' ');
                else
                    System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static void recur (int start, int len) {
        if(len <= start)
            return;
        else {
            for(int i = start; i < len; i++) {
                board[i][len-1] = '*';  // 맨 오른쪽 줄
                board[start][i] = '*';  // 맨 윗 줄
                board[len-1][i] = '*';  // 맨 아랫 줄
                board[i][start] = '*';  // 맨 왼쪽 줄
            }
            recur(start+ 2, len - 2);
        }
    }
}
