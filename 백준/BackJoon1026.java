package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BackJoon1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String num = br.readLine();
        StringTokenizer st = new StringTokenizer(num," ");
        int[] A = new int[n];
        int[] B = new int[n];
        for(int i=0; i<n; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        String num2 = br.readLine();
        StringTokenizer st2 = new StringTokenizer(num2," ");
        for(int i=0; i<n; i++){
            B[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B);

        int result = 0;
        for(int i=0; i<n; i++){
            result += A[i]*B[n-i-1];
        }
        System.out.println(result);
    }
}

