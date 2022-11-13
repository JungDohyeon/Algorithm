package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon11053 {
    static int[] arr = new int[1001];
    static int[] dp = new int[1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line, " ");
        int n = Integer.parseInt(st.nextToken());
        String numline = br.readLine();
        st = new StringTokenizer(numline, " ");
        for (int i = 1; i<=n; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] =num;
        }

        for(int i = 1; i<=n; i++){
            dp[i] = 1;      // 자기 자신은 무조건 갖기 때문에 1로 초기화
            for(int j = 1; j<i; j++){
                if(arr[j] < arr[i] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = 0;

        for(int i = 1; i<=n; i++){
            if(max < dp[i]){
                max = dp[i];
            }
        }
        System.out.println(max);
    }
}
