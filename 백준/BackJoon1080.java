package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon1080 {
    static int[][] arrA;
    static int[][] arrB;
    static int N, M;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arrA = new int[N][M];
        arrB = new int[N][M];

        for(int i = 0; i<N; i++){
             String lineA = br.readLine();
            for(int j = 0; j<M; j++){
                arrA[i][j] = lineA.charAt(j) - '0';
            }
        }

        for(int i = 0; i<N; i++){
            String lineB = br.readLine();
            for(int j = 0; j<M; j++){
                arrB[i][j] = lineB.charAt(j) - '0';
            }
        }

        for(int i = 0; i<N-2; i++){
            for(int j = 0; j<M-2; j++){
                if(arrA[i][j] != arrB[i][j]) {
                    reverse(i, j);  // 뒤집기
                    count++;
                }
            }
        }

        boolean check = true;
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(arrA[i][j] != arrB[i][j]){
                    check = false;
                    break;
                }
            }
        }
        System.out.println(check ? count : -1);
    }

    static void reverse(int a, int b){
        for(int i = a ; i < a + 3; i++) {
            for(int j = b; j < b+3; j++){
                arrA[i][j] = arrA[i][j] == 1  ? 0 : 1;
            }
        }
    }
}