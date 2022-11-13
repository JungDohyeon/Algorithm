package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BackJoon1247 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            BigInteger ans = new BigInteger("0");
            int n = Integer.parseInt(br.readLine());
            for (int j = 0; j < n; j++) {
                ans  = ans.add(new BigInteger(br.readLine()));
            }
            if (ans.signum() == 0) {
                sb.append(0).append("\n");
            } else if (ans.signum() == -1) {
                sb.append("-").append("\n");
            } else {
                sb.append("+").append("\n");
            }
        }
        System.out.println(sb);
    }
}
