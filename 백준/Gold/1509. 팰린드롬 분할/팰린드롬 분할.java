import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    static int[] dp;
    static boolean[][] isPalindrome;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int len = str.length();

        isPalindrome = new boolean[len + 1][len + 1];
        dp = new int[len + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        check(str);

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= i; j++) {
                if(isPalindrome[j][i]) {
                    dp[i] = Math.min(dp[i], dp[j-1] + 1);
                }
            }
        }

        bw.write(String.valueOf(dp[len]));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void check(String str) {
        int len = str.length();

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= len; j++) {
                boolean flag = true;

                int start = j - 1;
                int end = i - 1;

                while (start <= end) {
                    if (str.charAt(start++) != str.charAt(end--)) {
                        flag = false;
                        break;
                    }
                }

                if (flag)
                    isPalindrome[j][i] = true;
            }
        }
    }
}
