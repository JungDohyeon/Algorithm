package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ11279 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 최대 힙 구조
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i<N; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if(tmp == 0) {
                if(pq.isEmpty())
                    sb.append(0).append("\n");
                else
                    sb.append(pq.poll()).append("\n");
            } else  {
                pq.add(tmp);
            }
        }
        System.out.println(sb);
    }
}
