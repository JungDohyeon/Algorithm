package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1966 {
    static class Pair {
        int n, pri;

        public Pair(int n, int pri) {
            this.n = n;
            this.pri = pri;
        }
    }

    static LinkedList<Pair> q;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        for(int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());

            q = new LinkedList<>();

            // 중요도 받기 : (n, pri) 프린트 큐 생성.
            st = new StringTokenizer(br.readLine());
            for(int k = 0; k < n; k++) {
                q.offer(new Pair(k, Integer.parseInt(st.nextToken())));
            }

            int print = 0;  // 프린트 횟수.

            while(true) {
                Pair p = q.poll();  // 일단 앞에서 뽑음
                boolean check = true;   // 뽑은 원소가 가장 큰 원소인지 판별

                for(int r = 0; r < q.size(); r++) {
                    assert p != null;
                    if (q.get(r).pri > p.pri) {
                        q.offer(p);

                        // 뒤로 보낸다.
                        for(int m = 0; m < r; m++) {
                            q.offer(q.poll());
                        }

                        check = false;
                        break;
                    }
                }

                // 뽑은 원소가 가장 크지 않은 경우 다시 큐 탐색
                if(!check)
                    continue;

                // 프린트 횟수 +1
                print++;

                // 뽑은 원소가 가장 크다면 반복문 끝낸다.
                assert p != null;
                if(p.n == idx)
                    break;
            }

            sb.append(print).append("\n");
        }

        System.out.println(sb);
    }
}
