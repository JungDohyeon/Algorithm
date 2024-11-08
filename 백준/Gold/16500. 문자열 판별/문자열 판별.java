
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dp;
    static String[] arr;
    static String S;

    static HashSet<String> set;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        set = new HashSet<>();
        S = br.readLine();

        int targetLen = S.length();
        int n = Integer.parseInt(br.readLine());

        arr =  new String[n];
        dp = new int[targetLen + 1];

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        for (int i = targetLen - 1; i >= 0; i--) {
            for (int j = i + 1; j < targetLen; j++) {
                if (dp[j] == 1) {
                    if (set.contains(S.substring(i, j))) {
                        dp[i] = 1;
                    }
                }
            }

            if(set.contains(S.substring(i))) {
                dp[i] = 1;
            }
        }

        System.out.println(dp[0]);
    }
}
