package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            int score = 0;
            int successiveCircle = 1;

            for(int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == 'O') {
                    score +=successiveCircle;
                    successiveCircle++;
                } else {
                    successiveCircle = 1;
                }
            }
            sb.append(score + "\n");
        }
        System.out.println(sb);
    }
}
