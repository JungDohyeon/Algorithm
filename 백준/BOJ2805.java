package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2805 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        long max = 2000000000;


        for(int i = 0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long min = 0;

        while(min < max) {
            long sumLen = 0;
            long mid = (min + max) >> 1;

            for(int i = 0; i<N; i++) {
                long tmp = arr[i] - mid;

                // 잔여 높이를 더해줌
                if(tmp > 0)
                    sumLen += tmp;
            }

            if(sumLen >= M)
                min = mid + 1;
            else
                max = mid;
        }

        System.out.println(min - 1);
    }
}
