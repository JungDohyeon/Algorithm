package 백준;

import java.io.*;
import java.util.*;

public class BOJ2615 {
    static int[][] board;
    static int[] directX = {1, 0, 1, -1};
    static int[] directY = {1, 1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        board = new int[19][19];    // 보드판 생성
        int color = 0;
        int answerX = 0;
        int answerY = 0;

        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 전체 탐색 시작
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                // 가장 왼쪽이 먼저 나와야 하기 때문에 board[j][i]로 탐색 
                if (board[j][i] != 0) {
                    for (int k = 0; k < 4; k++) {
                        // 오목이 존재하는 경우 답 출력
                        if (SearchFive(j, i, k)) {
                            System.out.println(board[j][i]);
                            System.out.println((j+1) + " " + (i+1));
                            return;
                        }
                    }
                }
            }
        }

        // 없는 경우 0 출력
        System.out.println(0);
    }

    // 오목 찾기
    static boolean SearchFive(int x, int y, int dir) {
        int lengthChecker = 1;  // 오목 여부 확인

        int nx = x;
        int ny = y;

        int backx = x;
        int backy = y;

        // 증가 방향 탐색
        while (true) {
            nx += directX[dir];
            ny += directY[dir];

            // nx, ny가 바둑 판 내에 존재하고 같은 색으로 연속될 때
            if (checkValidation(nx, ny) && board[x][y] == board[nx][ny]) {
                lengthChecker++;
            } else
                break;
        }

        // 역방향 탐색
        while (true) {
            backx -= directX[dir];
            backy -= directY[dir];

            // nx, ny가 바둑 판 내에 존재하고 같은 색으로 연속될 때
            if (checkValidation(backx, backy) && board[x][y] == board[backx][backy]) {
                lengthChecker++;
            } else
                break;
        }

        // 딱 이어진 수가 5개 인경우
        if(lengthChecker == 5){
            return true;
        }
        return false;
    }

    // 범위 내에 좌표가 있는지 확인
    static boolean checkValidation(int x, int y) {
        if (x < 0 || x >= 19 || y < 0 || y >= 19)
            return false;
        return true;
    }
}

