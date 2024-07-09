import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static final long MOD =1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int m =  Integer.parseInt(br.readLine());
        long ans = 0;

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());

            int g = gcd(Math.max(N, S), Math.min(N, S));

            N /= g;
            S /= g;
            ans += S * solution(N,MOD - 2) % MOD;
            ans %= MOD;
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }

    static int gcd(int a, int b) {
        if(b == 0)
            return a;

        return gcd(b, a % b);
    }

    static long solution(long b, long n) {
        if(n == 1) 
            return b;

        long tmp = solution(b,n >> 1);
        long res = tmp * tmp % MOD;

        if(n % 2 == 1) {
            res = res * b % MOD;
        }

        return res;
    }
}