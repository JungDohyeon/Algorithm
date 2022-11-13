package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BackJoon1058 {
    static int n;
    static int[][] table;
    static int[] friendnum;
    static int MAX = 1000000;   // 친구가 아닌경우 처리
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        table = new int[n][n];
        friendnum = new int[n];

        for(int i = 0; i<n; i++){
            String line = br.readLine();
            for(int j = 0; j<n; j++){
                if(line.charAt(j) == 'Y'){
                    table[i][j] = 1;
                } else {
                    table[i][j] = MAX;
                }
            }
        }
        floyd();

        for(int i = 0; i<n; i++){
            int counter = 0;
            for(int j = 0; j<n; j++){
                if(table[i][j] < 3){
                    counter++;
                }
            }
            friendnum[i] = counter;
        }
        Arrays.sort(friendnum);
        System.out.println(friendnum[n-1]);
    }

    // floyd's algorithm
    public static void floyd(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++) {
                    if(i==j || j==k || i==k) continue;  // 자기 자신과는 친구가 아니다.
                    else if(table[j][k] > table[j][i] + table[i][k]){
                        table[j][k] = table[j][i] + table[i][k];
                    }
                }
            }
        }
    }
}
