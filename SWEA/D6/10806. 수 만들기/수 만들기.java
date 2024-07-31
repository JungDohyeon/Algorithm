import java.util.*;
import java.io.*;

class Solution {

    static int T, K;
    static int[] A;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            int N = Integer.parseInt(br.readLine());
            A = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            K = Integer.parseInt(br.readLine());

            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(K, 0));

            int cnt = K;
            while(!pq.isEmpty()){
                Node cur = pq.poll();

                if (cur.value == 0) {
                    cnt = cur.cnt;
                    break;
                }

                pq.add(new Node(0, cur.cnt + cur.value));

                for (int i = 0; i < N; i++){
                    pq.add(new Node( cur.value / A[i], cur.cnt + cur.value % A[i]));
                }
            }

            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static class Node implements Comparable<Node>{
        int value;
        int cnt;

        public Node(int value, int cnt){
            this.value = value;
            this.cnt = cnt;
        }

        public int compareTo(Node n){
            return Integer.compare(this.cnt, n.cnt);
        }
    }
}