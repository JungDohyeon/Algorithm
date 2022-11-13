package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackJoon1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String num = br.readLine();
            boolean check = true;
            if (num.equals("0")) {
                break;
            } else {
                for (int i = 0; i < num.length() / 2; i++) {
                    if (num.charAt(i) != num.charAt(num.length() - 1 - i)) {
                        check = false;
                        break;
                    }
                }
                if (check)
                    sb.append("yes").append("\n");
                else
                    sb.append("no").append("\n");
            }
        }
        System.out.println(sb);
    }
}
