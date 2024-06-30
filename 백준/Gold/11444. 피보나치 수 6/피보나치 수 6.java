
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Main {

    final static long MOD = 1000000007;

    static long N;
    static HashMap<Long, Long> dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Long.parseLong(br.readLine());
        dp = new HashMap<>();

        dp.put(0L, 0L);
        dp.put(1L, 1L);
        dp.put(2L, 1L);
        dp.put(3L, 2L);

        bw.write(Long.valueOf(fibo(N)).toString());
        bw.flush();
        bw.close();
    }

    private static long fibo(long n) {
        if (dp.containsKey(n)) {
            return dp.get(n);
        }

        long a, b, c;

        if (n % 2 == 1) {
            a = fibo((n >> 1) + 1) % MOD;
            b = fibo(n >> 1) % MOD;

            dp.put(n, (a * a % MOD + b * b % MOD) % MOD);
        } else {
            a = fibo((n >> 1) + 1) % MOD;
            b = fibo(n >> 1) % MOD;
            c = fibo((n >> 1) - 1) % MOD;

            dp.put(n, (a * b % MOD + b * c % MOD) % MOD);
        }

        return dp.get(n);
    }
}
