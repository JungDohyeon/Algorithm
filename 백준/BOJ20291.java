package 백준;

// 파일 정리
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ20291 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N  = Integer.parseInt(br.readLine());
        Map<String, Integer> tmap = new TreeMap<>();    // treemap 선언

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), ".");   // .을 기준으로 분리
            st.nextToken(); // 파일 이름은 필요 없음
            String extension = st.nextToken();  // 파일의 확장자 얻기

            // 확장자가 이미 있는 경우 value값을 1 증가
            if(tmap.containsKey(extension)) {
                int beforeVal = tmap.get(extension);
                tmap.replace(extension, beforeVal+1);
            }
            // 확장자가 없는 경우 새로 삽입
            else {
                tmap.put(extension, 1);
            }
        }

        // 순회하며 출력
        for(String k: tmap.keySet()) {
            sb.append(k).append(" ").append(tmap.get(k)).append("\n");
        }

        System.out.println(sb);
    }
}
