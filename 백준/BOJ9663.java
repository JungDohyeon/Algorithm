package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// N - Queen
public class BOJ9663 {
    static int chess[];
    static int N;
    static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());    // N 입력 받기
        chess = new int[N];
        count = 0;

        QueenCount(0);
        System.out.println(count);
    }

    static void QueenCount(int depth) {

        // 퀸을 N개 모두 배치 한 경우
        if(depth == N) {
            count++;
            return;
        }

        for(int i = 0; i<N; i++) {
            chess[depth] = i;   // depth열에 0 ~ N-1 행까지 차례대로 들어간다.

            // 해당 depth열 i 행에 배치 가능하면 다음 열 생각
            if(validationQueen(depth)) {
                QueenCount(depth+1);
            }
        }
    }

    static boolean validationQueen(int depth) {
        for(int col = 0; col<depth; col++) {
            // 같은 행에 존재하는 경우
            if(chess[depth] == chess[col])
                return false;
            // 대각선에 놓여 있는 경우
            else if (Math.abs(depth-col) == Math.abs(chess[depth] - chess[col]))
                return false;
        }
        return true;
    }
}
