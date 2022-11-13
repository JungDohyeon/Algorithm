package 백준;

// LCS - Longest Common Subsequence
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ9251 {
    static int dp[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();    // 문자열 1
        String str2 = br.readLine();    // 문자열 2

        int len1 = str1.length();
        int len2 = str2.length();

        dp = new int[len1 + 1][len2 + 1];   // dp 배열 생성

        for(int i = 1; i <= len1; i++) {
            for(int j = 1; j <= len2; j++) {
                // 문자열이 같은 경우
                if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                // 문자열이 다른 경우
                else {
                    dp[i][j] = dp[i-1][j] > dp[i][j-1] ? dp[i-1][j] : dp[i][j-1];
                }
            }
        }
        System.out.println(dp[len1][len2]);
    }
}
