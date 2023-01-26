package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ10870 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(fibo(n));
    }

    public static int fibo(int n) {
        if(n ==0)
            return 0;
        else if(n==1)
            return 1;
        else
            return fibo(n - 1) + fibo(n - 2);
    }
}
