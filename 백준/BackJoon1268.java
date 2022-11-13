package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon1268 {
    static int[][] arr = new int[1000][5];
    static int[] counter = new int[1000];

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ") ;
            for(int j = 0; j < 5; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    if(arr[j][i] == arr[k][i] && j != k){
                        counter[j] += 1;
                    }
                }
            }
        }

        int max = 0;
        int studentId = 0;
        for(int i = 0; i<n; i++){
            if(max < counter[i]) {
                max = counter[i];
                studentId = i + 1;
            } else if(max == counter[i]){
                if(studentId > i)
                    studentId= i + 1;
            }
        }
        System.out.println(studentId);
    }
}
