package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon1018 {
    static int minCheck = 64;
    static boolean[][] checkColor;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String size = br.readLine();
        StringTokenizer st = new StringTokenizer(size, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        checkColor = new boolean[N][M];

        for(int i = 0; i<N; i++){
            String lineColor = br.readLine();
            for(int j = 0; j<M; j++){
                // 흰색이면 true, 검정색이면 false
                if(lineColor.charAt(j) == 'W'){
                    checkColor[i][j] = true;
                } else {
                    checkColor[i][j] = false;
                }
            }
        }

        // 8 * 8 체스판으로 잘라서 각 경우의 최소 값 구하기
        int checkN  = N - 7;
        int checkM = M - 7;

        for (int i =0; i<checkN; i++){
            for(int j = 0; j<checkM; j++){
                getMin(i, j);
            }
        }
        System.out.println(minCheck);
    }

    public static void getMin(int n, int m){
        int nowN = n + 8;
        int nowM = m + 8;
        int counter = 0;
        boolean check = checkColor[n][m];

        for (int i = n; i <nowN; i++){
            for(int j = m; j<nowM; j++){
                if(checkColor[i][j] != check){
                    counter++;
                }
                check = !check;
            }
            check = !check;
        }
        counter = Math.min(counter, 64 - counter);
        minCheck = Math.min(minCheck, counter);
    }
}
