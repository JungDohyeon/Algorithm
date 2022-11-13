package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2164 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i<=N; i++) {
            q.offer(i);
        }

        while (q.size() > 1) {
            q.poll();   // 맨위 제거
            if(q.size() == 1)   // 한 개만 남았다면 반복 탈출
                break;

            q.offer(q.poll());  // 뽑아서 맨 뒤로 넣기
        }

        System.out.println(q.poll());
    }
}
