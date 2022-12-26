package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1806 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int ans = 100001;

        while(true) {
            if(sum >= S) {
                sum -= arr[start];
                ans = Math.min(ans, end - start);
                if(ans == 2)
                    break;
                start++;
            }
            else if (end == N) {
                break;
            } else {
                sum += arr[end++];
            }
        }

        if(ans == 100001)
            System.out.println(0);
        else
            System.out.println(ans);
    }
}
