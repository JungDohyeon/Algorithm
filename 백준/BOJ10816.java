package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10816 {
    static int[] storage;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        storage = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++) {
            storage[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(storage);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<M; i++) {
            int searchingNum = Integer.parseInt(st.nextToken());
            sb.append(upper_bound(storage, searchingNum) - lower_bound(storage, searchingNum)).append(" ");
        }
        System.out.println(sb);
    }

    static int lower_bound(int[] arr, int search) {
        int low = 0;
        int high = arr.length;

        while(low < high) {
            int mid = (low + high) >> 1;
            if (search <= arr[mid])
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }

    static int upper_bound(int[] arr, int search) {
        int low = 0;
        int high = arr.length;

        while(low < high) {
            int mid = (low + high) >> 1;
            if (search >= arr[mid])
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}
