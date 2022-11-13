package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon1934 {

    public static int gcd (int n, int m){
        if(m == 0){
            return n;
        } else {
            return gcd(m, n % m);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int big = Math.max(a, b);
            int small = Math.min(a, b);

            int gcd = gcd(big, small);

            sb.append(big*small/gcd).append("\n");
        }
        System.out.println(sb);
    }
}
