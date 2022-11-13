package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 분할 정복,,
public class BackJoon1074 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String l = br.readLine();
        StringTokenizer st = new StringTokenizer(l," ");
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        // x, y는 배열의 중점 표기
        int x = (int)Math.pow(2, N-1);
        int y = x;

        int result = 0;
        while(N-- > 0){
            int newSize = (int)Math.pow(2, N - 1);  // 정사각형의  중앙값 정의
            int completeSearch = (int)Math.pow(4, N);       // 현 상태에서의 부분 각 사분면 정사각형의 크기

            if(c < x && r < y){
                x -= newSize;
                y -= newSize;
            } else if (c >= x && r < y){
                x += newSize;
                y -= newSize;
                result += completeSearch;
            } else if (c < x && y <= r){
                x -= newSize;
                y += newSize;
                result += completeSearch * 2;
            } else {
                x += newSize;
                y += newSize;
                result += completeSearch * 3;
            }
        }
        System.out.println(result);
    }
}
