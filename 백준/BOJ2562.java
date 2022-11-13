package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ2562 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int idx = 0;
        int max = 0;

        for(int i = 0; i < 9; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if(max < tmp) {
                max = tmp;
                idx = i+1;
            }
        }
        System.out.println(max);
        System.out.println(idx);
    }
}
