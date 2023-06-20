package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1912 {
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[n];
        dp = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        int max = arr[0];

        for(int i = 1; i < n; i++) {
            dp[i] = Math.max(arr[i], dp[i-1] + arr[i]);
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
