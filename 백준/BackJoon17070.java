package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon17070 {
    static int[][] table;
    static int n;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         n = Integer.parseInt(br.readLine());
        table = new int[n+1][n+1];
        for(int i = 1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j<=n; j++){
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        DFS(1,2,0); // 초기 값은 (1,1), (1,2)에 누워있는 가로형태
        System.out.println(answer);
    }

    // state : 0 - 가로, 1 - 세로, 2 - 대각
    public static void DFS (int x, int y, int state){
        // 목적지에 도달한 경우 1 증가
        if(x == n && y==n){
            answer++;
            return;
        }

        // 가로, 대각 -> 공통점: 가로
        if(state == 0 || state == 2){
            if(y+1 <=n && table[x][y+1] != 1){
                DFS(x, y+1, 0); // 가로로 전진
            }
        }

        // 세로, 대각 -> 공통점: 세로
        if(state == 1 || state==2){
            if(x+1<=n && table[x+1][y] != 1){
                DFS(x+1,  y, 1); // 세로로 전진
            }
        }

        if(x+1 <=n && y+1 <= n && table[x+1][y] != 1 && table[x][y+1] != 1 && table[x+1][y+1] != 1){
            DFS(x+1, y+1, 2);   // 대각 전진
        }
    }
}