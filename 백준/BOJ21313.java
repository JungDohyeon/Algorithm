package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ21313 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());    // 문어 수

        for(int i = 0; i < N/2; i++) {
            sb.append("1").append(" ").append("2").append(" ");
        }

        if(N % 2 == 1)
            sb.append("3");

        bw.write(sb.toString());
        bw.flush();
    }
}
