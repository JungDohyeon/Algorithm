import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int N;
    static int[] dp;
    static boolean[][] isPalindrome;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        N = str.length();
        str = "." + str;

        isPalindrome = new boolean[N + 1][N + 1];

        dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i-1] + 1;

            for (int j = 1; j <= i; j++) {
                if(i == j) {
                    isPalindrome[i][j] = true;
                    continue;
                }

                if(str.charAt(i) != str.charAt(j))
                    continue;

                if (i - j == 1) {
                    isPalindrome[i][j] = true;
                } else {
                    isPalindrome[i][j] = isPalindrome[i - 1][j + 1];
                }

                if(isPalindrome[i][j]){
                    dp[i] = Math.min(dp[i], dp[j-1]+1);
                }
            }
        }

        bw.write(String.valueOf(dp[N]));
        bw.flush();
        bw.close();
        br.close();
    }
}
