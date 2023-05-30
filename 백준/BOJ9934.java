package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ9934 {
    static int K;
    static int[] arr;
    static List<ArrayList<Integer>> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        K = Integer.parseInt(br.readLine());    // depth
        int cnt = (int) Math.pow(2, K) - 1; // 완전 이진 트리에서 depth가 주어졌을 때 노드의 갯수
        arr = new int[cnt];   // 노드 저장 배열 (중위순회 결과 값)

        // input 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < cnt; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // list Initialize
        list = new ArrayList<>();
        for(int i = 0; i < K; i++) {
            list.add(new ArrayList<>());
        }

        solution(0, cnt, 0);

        // 출력
        for(int i = 0; i < K; i++) {
            for(int j : list.get(i)) {
                sb.append(j).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void solution(int start, int end, int depth) {
        // 마지막 depth 까지 도달했다면 재귀 종료
        if (depth == K)
            return;

        // 중앙 노드 인덱스
        int midIdx = (start + end) >> 1;

        list.get(depth).add(arr[midIdx]);   // 현재 깊이에 맞게 정점 삽입.
        solution(start, midIdx - 1, depth + 1); // 가운데 기준으로 왼쪽 하위 구간 탐색
        solution(midIdx + 1, end, depth + 1);   // 가운데 기준으로 오른쪽 하위 구간 탐색
    }
}
