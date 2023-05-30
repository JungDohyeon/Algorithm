package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ17073 {
    /*
        주어진 문제에서 물은 W로 항상 유지된다. 그리고 물이 더이상 이동하지 않는 경우는 모든 물이 리프노드에 떨어졌을 경우이다.
        또한 자식 노드로 흘러보내는 확률은 모두 반 반으로 나눠지며 리프노드의 기댓값의 총 합은 W와 같게 된다.
        따라서 w를 리프노드의 갯수로 나눠주면 답이 나온다.
     */

    static List<ArrayList<Integer>> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 트리 노드 수
        int W = Integer.parseInt(st.nextToken());   // 물의 양
        int leafNode = 0;

        // list Initialize
        list = new ArrayList<>();
        for(int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }

        // input 간선 삽입
        for(int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            // 간선 삽입
            list.get(U).add(V);
            list.get(V).add(U);
        }

        // leafnode 갯수 구하기. (연결된 노드가 한 개라면 leafNode이다. 루트 노드는 제외하고 leafNode를 구하기 때문에 2부터 시작.)
        for(int i = 2; i < N+1; i++) {
           if (list.get(i).size() == 1) {
              leafNode++;
           }
        }

        System.out.printf("%.6f" ,(double) W / leafNode);
    }
}
