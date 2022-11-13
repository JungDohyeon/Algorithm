package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon10986 {
    static int[] arr;
    static int[] sumArr;
    static int[] modular;
    static long result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        sumArr = new int[n+1];
        modular = new int[m+1];

        st = new StringTokenizer(br.readLine()," ");
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sumArr[i] = sumArr[i-1] + arr[i];
        }

        for(int i = 1; i<=n; i++){
            modular[sumArr[i] % m]++;
        }

        result += modular[0];

        for(int i = 0; i < m; i++){
            result += (long) modular[i]*(modular[i]-1)/2;
        }

        System.out.println(result);
    }
}
