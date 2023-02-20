package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class BOJ13414 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        LinkedHashSet<String> hashSet = new LinkedHashSet<>();

        for(int i = 0; i < N; i++) {
            String str = br.readLine();

            // 이전에 신청 버튼을 누른 학생이라면 제거 후 새로 추가.
            if(hashSet.contains(str)) {
                hashSet.remove(str);
            }

            hashSet.add(str);
        }


        int cnt = 0;

        // 출력 (advanced for loop)
        for(String str: hashSet) {
            cnt++;
            sb.append(str).append("\n");
            if(cnt == K)
                break;
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
