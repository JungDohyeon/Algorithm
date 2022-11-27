package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2470 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int leftIdx = 0;
        int rightIdx = N - 1;

        int ansLeft  = 0;
        int ansRight = 0;

        int absSum = Integer.MAX_VALUE;

        while(leftIdx < rightIdx) {
            int beforeAbs = arr[leftIdx] + arr[rightIdx];
            int tmp = Math.abs(beforeAbs);

            // 최소 절댓값 갱신
            if(tmp < absSum) {
                absSum = tmp;
                ansLeft = arr[leftIdx];
                ansRight = arr[rightIdx];
            }

            // 양수라면
            if(beforeAbs < 0)
                leftIdx++;
            else
                rightIdx--;
        }

        System.out.println(ansLeft + " " + ansRight);
    }
}
