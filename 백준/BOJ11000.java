package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ11000 {

    public static class ClassTime implements Comparable<ClassTime>{
        int S, T;

        public ClassTime(int S, int T) {
            this.S = S;
            this.T = T;
        }

        @Override
        public int compareTo(ClassTime o) {
            if (S == o.S) {
                return T - o.T;
            }

            return S - o.S;
        }
    }

    static ClassTime[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new ClassTime[N];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            arr[i] = new ClassTime(S, T);
        }

        Arrays.sort(arr);

        // 우선순위 큐에 삽입. (종료 시간 기준)
        pq.offer(arr[0].T);

        // idx 1 부터 탐색 (0은 이미 들어가 있음)
        for(int i = 1; i < N; i++) {
            // 우선순위 큐에 있는 최단 종료 시각보다 시작 시간이 같거나 긴경우 다음 수업 시작

            if(!pq.isEmpty()) {
                if(arr[i].S >= pq.peek()) {
                    pq.poll();
                }
                pq.offer(arr[i].T);
            }
        }

        System.out.println(pq.size());
    }
}
