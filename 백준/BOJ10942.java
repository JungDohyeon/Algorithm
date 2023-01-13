package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10942 {
    static int[] arr;
    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int  n = Integer.parseInt(br.readLine());
        arr = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int test = Integer.parseInt(br.readLine());

        for(int i = 0; i < test; i++) {
            st = new StringTokenizer(br.readLine());
            int first_idx = Integer.parseInt(st.nextToken());
            int second_idx = Integer.parseInt(st.nextToken());

            if(first_idx == second_idx) {
                sb.append(1).append("\n");
            } else if (second_idx - first_idx == 1){
                if(arr[first_idx] == arr[second_idx]) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else {
                if(palindrome(first_idx, second_idx)) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            }
        }
        System.out.println(sb);
    }

    static boolean palindrome(int idx1, int idx2) {
        int left = idx1;
        int right = idx2;

        while(left < right) {
            if (arr [left] == arr[right]) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
