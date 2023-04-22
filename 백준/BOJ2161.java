package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2161 {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();


        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();

        // n까지 더하기
        for(int i = 1; i <= n; i++) {
            q.add(i);
        }

        while(q.size() != 1) {
            sb.append(q.poll()).append(" ");
            q.add(q.poll());
        }

        sb.append(q.poll());

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
