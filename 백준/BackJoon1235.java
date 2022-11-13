package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackJoon1235 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());

        String[] id = new String[n];

        for(int i = 0; i<n; i++){
            id[i] = br.readLine();
        }

        int ans = 1;

        for(int i = 0; i<id.length-1; i++){
            for(int j = i+1; j<id.length; j++){
                int index = id[0].length()-1;
                int counter = 1;
                while((id[i].charAt(index) == id[j].charAt(index)) && index >= 0){
                   counter++;
                   index--;
                }
               ans =  ans > counter ? ans : counter;
            }
        }
        System.out.println(ans);
    }
}
