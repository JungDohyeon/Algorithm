package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3020 {
    static int[] bot;   // 석순
    static int[] top;   // 종유석

    static int[] dp_bot;
    static int[] dp_top;

    static int N, H;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        // 높이 저장 배열 (최대 H까지 높이 설정 가능)
        bot = new int[H + 1];
        top = new int[H + 1];

        // 누적 합 배열
        dp_bot = new int[H + 1];
        dp_top = new int[H + 1];

        for(int i = 0; i<N; i++) {
            // 석순
            if(i % 2 == 0) {
                bot[Integer.parseInt(br.readLine())]++;
            }
            // 종유석
            else {
                top[Integer.parseInt(br.readLine())]++;
            }
        }

        // 누적 합 계산
        getSum();
        getAnswer();
    }

    // 누적 합 계산
    static void getSum() {
        // 누적 합 계산
        for(int i = 1; i < H + 1; i++) {
            dp_bot[i] = dp_bot[i - 1] + bot[i];
            dp_top [i] = dp_top[i - 1] + top[i];
        }
    }

    static void getAnswer() {
        int cnt = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 1; i < H + 1; i++) {
            int destroy =  (dp_bot[H] - dp_bot[i - 1]) + (dp_top[H] - dp_top[H - i]);
            if(destroy < min) {
                cnt = 1;
                min = destroy;
            } else if (destroy == min) {
                cnt++;
            }
        }

        System.out.println(min + " " + cnt);
    }
}
