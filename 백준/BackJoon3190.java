package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon3190 {
    public static  void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int K  = Integer.parseInt(br.readLine());

        // 사과 위치
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int col = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());

        }
    }
}
