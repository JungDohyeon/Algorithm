package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon1059 {
    static int[] arr;
    static int L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        L = Integer.parseInt(br.readLine());
        arr = new int[L];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < L; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int n = Integer.parseInt(br.readLine());
       boolean flag = true;

        int lBound= 0;
        int hBound = 1111;

        for(int i = 0; i<L; i++){
            if(n == arr[i]){
                flag = false;
                break;
            }

            if(arr[i] > n && arr[i] <  hBound) {
                hBound = arr[i];
            }

            if(arr[i] < n && arr[i] > lBound) {
                lBound = arr[i];
            }
        }

        System.out.println(flag ? ((n-lBound) * (hBound - n) - 1) : 0);
    }
}
