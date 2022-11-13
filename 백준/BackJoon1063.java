package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon1063 {
    public static boolean[][] board;
    static int kingRow, kingCol, stoneRow, stoneCol;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String kingLoc = st.nextToken();    // king의 처음 위치
        String stoneLoc = st.nextToken();   // 돌의 처음 위치
        int n  = Integer.parseInt(st.nextToken()); // 이동 횟수
        board = new boolean[8][8];

        kingRow = kingLoc.charAt(0) - 'A';
        kingCol = Math.abs((kingLoc.charAt(1) - '1') - 8);
        stoneRow = stoneLoc.charAt(0) - 'A';
        stoneCol = Math.abs((stoneLoc.charAt(1) - '1') - 8);

        for(int i = 0; i<8; i++){
            for(int j = 0; j<8; j++){
                if(i==kingCol  && j == kingRow){
                    board[i][j] = true;
                } else if (i==stoneRow && j == stoneCol) {
                    board[i][j] = true;
                } else {
                    board[i][j] = false;
                }
            }
        }

        for(int i = 0; i < n; i++){
            move(br.readLine());
        }

        System.out.println((char)(kingRow + 'A') + "" + (Math.abs(kingCol - 8) + 1));
        System.out.println((char)(stoneRow + 'A') + "" + (Math.abs(stoneCol - 8) + 1));
    }

    public static void move(String locate){
        switch(locate){
            case "R":
                if(kingRow + 1 < 8){
                    if(stoneRow == kingRow + 1){
                        if(stoneRow + 1 < 8){
                            board[stoneCol][stoneRow] = false;
                            board[kingCol][kingRow] = false;
                            stoneRow++;
                            kingRow ++;
                            board[stoneCol][stoneRow] = true;
                            board[kingCol][kingRow] = true;
                        }
                    } else {
                        board[kingCol][kingRow] = false;
                        kingRow ++;
                        board[kingCol][kingRow] = true;
                    }
                }
                break;
            case "L":
                if(kingRow - 1 >= 0){
                    if(stoneRow == kingRow - 1){
                        if(stoneRow - 1 >= 0){
                            board[stoneCol][stoneRow] = false;
                            board[kingCol][kingRow] = false;
                            stoneRow--;
                            kingRow --;
                            board[stoneCol][stoneRow] = true;
                            board[kingCol][kingRow] = true;
                        }
                    } else {
                        board[kingCol][kingRow] = false;
                        kingRow--;
                        board[kingCol][kingRow] = true;
                    }
                }
                break;
            case "B":
                if(kingCol + 1 < 8){
                    if(stoneCol == kingCol + 1){
                        if(stoneCol+ 1 < 8){
                            board[stoneCol][stoneRow] = false;
                            board[kingCol][kingRow] = false;
                            stoneCol++;
                            kingCol ++;
                            board[stoneCol][stoneRow] = true;
                            board[kingCol][kingRow] = true;
                        }
                    } else {
                        board[kingCol][kingRow] = false;
                        kingCol ++;
                        board[kingCol][kingRow] = true;
                    }
                }
                break;
            case "T":
                if(kingCol - 1 >= 0){
                    if(stoneCol == kingCol - 1){
                        if(stoneCol - 1 >= 0){
                            board[stoneCol][stoneRow] = false;
                            board[kingCol][kingRow] = false;
                            stoneCol--;
                            kingCol--;
                            board[stoneCol][stoneRow] = true;
                            board[kingCol][kingRow] = true;
                        }
                    } else {
                        board[kingCol][kingRow] = false;
                        kingCol --;
                        board[kingCol][kingRow] = true;
                    }
                }
                break;
            case "RT":
                if(kingCol - 1 >= 0  && kingRow + 1 < 8){
                    if(stoneCol == kingCol - 1 && stoneRow == kingRow + 1){
                        if(stoneCol - 1 >= 0 && stoneRow + 1 < 8){
                            board[stoneCol][stoneRow] = false;
                            board[kingCol][kingRow] = false;
                            stoneCol--;
                            stoneRow++;
                            kingCol--;
                            kingRow++;
                            board[stoneCol][stoneRow] = true;
                            board[kingCol][kingRow] = true;
                        }
                    } else {
                        board[kingCol][kingRow] = false;
                        kingCol --;
                        kingRow++;
                        board[kingCol][kingRow] = true;
                    }
                }
                break;

            case "LT":
                if(kingCol -1 >= 0  && kingRow - 1 >= 0){
                    if(stoneCol == kingCol - 1 && stoneRow == kingRow - 1){
                        if(stoneCol - 1 >= 0 && stoneRow - 1 >= 0){
                            board[stoneCol][stoneRow] = false;
                            board[kingCol][kingRow] = false;
                            stoneCol--;
                            stoneRow--;
                            kingCol--;
                            kingRow--;
                            board[stoneCol][stoneRow] = true;
                            board[kingCol][kingRow] = true;
                        }
                    } else {
                        board[kingCol][kingRow] = false;
                        kingCol --;
                        kingRow--;
                        board[kingCol][kingRow] = true;
                    }
                }
                break;

            case "RB":
                if(kingCol + 1 < 8 && kingRow + 1 < 8){
                    if(stoneCol == kingCol + 1 && stoneRow == kingRow + 1){
                        if(stoneCol+ 1 < 8 && stoneRow + 1 < 8){
                            board[stoneCol][stoneRow] = false;
                            board[kingCol][kingRow] = false;
                            stoneCol++;
                            stoneRow++;
                            kingCol ++;
                            kingRow++;
                            board[stoneCol][stoneRow] = true;
                            board[kingCol][kingRow] = true;
                        }
                    } else {
                        board[kingCol][kingRow] = false;
                        kingCol ++;
                        kingRow++;
                        board[kingCol][kingRow] = true;
                    }
                }
                break;
            case "LB":
                if(kingCol + 1 < 8 && kingRow - 1 >= 0){
                    if(stoneCol == kingCol + 1 && stoneRow == kingRow - 1){
                        if(stoneCol+ 1 < 8 && stoneRow - 1 >= 0){
                            board[stoneCol][stoneRow] = false;
                            board[kingCol][kingRow] = false;
                            stoneCol++;
                            stoneRow--;
                            kingCol ++;
                            kingRow--;
                            board[stoneCol][stoneRow] = true;
                            board[kingCol][kingRow] = true;
                        }
                    } else {
                        board[kingCol][kingRow] = false;
                        kingCol ++;
                        kingRow--;
                        board[kingCol][kingRow] = true;
                    }
                }
                break;
        }
    }
}
