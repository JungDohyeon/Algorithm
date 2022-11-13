package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1105 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String L = st.nextToken();
        String R = st.nextToken();

        int answer = 0;

        // 자리 수가 다른 경우 답은 0이다.
        if(L.length() != R.length()){
            System.out.println(answer);
        }
        // 자리 수가 같은 경우 각 맨 앞자리 수 부터 비교하며 8의 개수를 센다.
        else {
            int i = 0;
            while( i < L.length() && L.charAt(i) == R.charAt(i)) {
               if(L.charAt(i)  == '8') {
                   answer++;
               }
               i++;
            }
            System.out.println(answer);
        }
    }
}
