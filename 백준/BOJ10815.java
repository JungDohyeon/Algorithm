package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10815 {
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < m; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            binarySearch(0, n-1, tmp);
        }

        System.out.println(sb);
    }

    static void binarySearch(int start, int end, int target) {
        while(start <= end) {
            int mid = (start + end) >> 1;

            if(arr[mid] == target) {
                sb.append("1" + " ");
                return;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else
                start = mid + 1;
        }

        sb.append("0" + " ");
    }
}
