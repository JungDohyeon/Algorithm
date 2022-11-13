package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> q = new LinkedList<>();
        String extract = br.readLine();
        StringTokenizer st = new StringTokenizer(extract, " ");
        int n = Integer.parseInt(st.nextToken());   // 큐 크기
        int c = Integer.parseInt(st.nextToken());   // 뽑으려는 수 개수

        for (int i = 0; i < n; i++)
            q.add(i+1);     // 연결 리스트에 저장

        String list = br.readLine();
        StringTokenizer ts = new StringTokenizer(list, " ");
        int count = 0;  // 2, 3번 연산 횟수 누적 합

        for (int i = 0; i < c; i++) {
            int findnum = Integer.parseInt(ts.nextToken());
            int index = q.indexOf(findnum);

            // 중간 지점 또는 중간보다 앞에 있는 경우
            if (index <= q.size() / 2) {
                // 수를 찾을 때 까지 뒤로 보낸다 (2번 연산 실행)
                while (findnum != q.getFirst()) {
                    q.offerLast(q.pollFirst());
                    count++;
                }
            }
            // 중간 지점보다 뒤에 있는 경우
            else {
                // 수를 찾을 때 까지 뒤의 원소를 모두 앞으로 보낸다.  (3번 연산 실행)
                while (findnum != q.getFirst()) {
                    q.offerFirst(q.pollLast());
                    count++;
                }
            }
            // 연산이 끝난 후 맨 앞 원소 삭제
            q.remove();
        }
        System.out.println(count);
    }
}

