package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ2446 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                sb.append(' ');
            }
            for (int k = 0; k < (2 * N - 1) - (2 * i); k++) {
                sb.append('*');
            }
            sb.append('\n');
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = 1; j < (N - 1) - i; j++) {
                sb.append(' ');
            }
            for (int k = 0; k < 3 + 2 * i; k++) {
                sb.append('*');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

}