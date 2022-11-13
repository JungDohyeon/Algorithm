package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public  class BOJ1022{
    static int r1,c1, r2, c2, max;
    static int[][] board;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        board = new int[r2 - r1 + 1][c2 - c1 + 1];
        calNum();

        int maxLen = (int)Math.log10(max), len;

        for(int i = 0; i<= r2-r1; i++) {
            for(int j = 0; j<= c2-c1; j++) {
                len = maxLen - (int)Math.log10(board[i][j]);
                for(int k = 0; k<len; k++) {
                    System.out.print(" ");
                }
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void calNum() {
        int x = 0, y = 0, dir = 0;
        int pushNum = 1, dist = 1, cnt = 0;
        while(!filled()) {
            if (x >= r1 && x <= r2 && y >= c1 && y <= c2) {
                board[x - r1][y - c1] = pushNum;
            }
            pushNum++;
            cnt++;
            x += dx[dir];
            y += dy[dir];

            if (cnt == dist) {
                cnt = 0;
                if(dir ==1 || dir == 3)
                    dist++;
                dir = (++dir)%4;
            }
        }
        max = pushNum - 1;
    }

    static boolean filled() {
        return board[0][0] != 0 && board[r2-r1][0] != 0&& board[0][c2-c1] != 0 && board[r2 - r1][c2 - c1] != 0;
    }
}