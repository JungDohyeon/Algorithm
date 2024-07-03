
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    static int[][] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s1 = br.readLine();
        String s2 = br.readLine();

        setLCSTable(s1, s2);
        getLCSString(s1, s1.length(), s2.length());

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void setLCSTable(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        dp = new int[len1 + 1][len2 + 1];

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        sb.append(dp[len1][len2]).append("\n");
    }

    private static void getLCSString(String str, int i, int j) {
        Stack<Character> st = new Stack<>();
        while(i > 0 && j > 0) {
            if(dp[i][j] == dp[i-1][j])
                i--;
            else if (dp[i][j] == dp[i][j-1])
                j--;
            else {
                st.push(str.charAt(i-1));
                i--;
                j--;
            }
        }

        while(!st.isEmpty()) {
            sb.append(st.pop());
        }
    }
}
