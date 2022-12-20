package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1541 {
    public static void main(String[] args) throws Exception {
        int sum = 0;
        boolean flag = true;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 덧셈 먼저 수행 후 뺄셈을 해야 최솟 값
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        while(st.hasMoreTokens()) {
            int tmp = 0;
            String subtractFraction = st.nextToken();

            StringTokenizer add = new StringTokenizer(subtractFraction, "+");
            while(add.hasMoreTokens()) {
                tmp += Integer.parseInt(add.nextToken());
            }

            if(flag) {
                sum  = tmp;
                flag = false;
            } else {
                sum -= tmp;
            }
        }
        System.out.println(sum);
    }
}
