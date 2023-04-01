package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ10952 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String str = br.readLine();

            int A = str.charAt(0) - 48;
            int B = str.charAt(2) - 48;

            if(A==0 && B==0) {
                break;
            }

            sb.append((A+B)).append('\n');
        }
        System.out.println(sb);
    }
}