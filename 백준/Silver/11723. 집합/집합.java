
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int bitset;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bitset = 0;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String op = st.nextToken();

            int value = 0;

            if(!op.equals("all") && !op.equals("empty")) {
                value = Integer.parseInt(st.nextToken());
            }

            solution(op, value);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void solution(String op, int value) {
        switch (op) {
            case "add":
                bitset |= (1 << (value - 1));
                break;

            case "remove":
                bitset = bitset & ~(1 << (value - 1));
                break;

            case "check":
                sb.append((bitset & (1 << (value - 1))) != 0 ? 1 : 0).append("\n");
                break;

            case "toggle":
                bitset ^= (1 << (value - 1));
                break;

            case "all":
                bitset |= (~0);
                break;

            case "empty":
                bitset &= 0;
                break;
        }
    }
}
