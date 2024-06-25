import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static long A, B, C;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        bw.write(String.valueOf(exponential(A, B)));
        bw.flush();
        bw.close();
    }

    private static long exponential(long num, long exp) {
        if (exp == 1) {
            return num % C;
        }
        
        long tmp = exponential(num, exp >> 1);
        
        if (exp % 2 == 1) {
            return (tmp * tmp % C) * num % C;
        } else {
            return tmp * tmp % C;
        }
    }
}
