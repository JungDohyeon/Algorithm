package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String l = br.readLine();
        StringTokenizer st = new StringTokenizer(l, " ");
        int n = Integer.parseInt(st.nextToken());
        int[] DP = new int[5001];
        DP[3] = DP[5] = 1;

        for(int i = 6; i<=n; i++){
            if(DP[i-3] != 0) {
                DP[i]  = DP[i-3] + 1;
            }
            if(DP[i-5] != 0){
                DP[i] = DP[i] != 0 ? Math.min(DP[i], DP[i-5]+1) : DP[i-5] + 1;
            }
        }
        System.out.println(DP[n] == 0 ? -1 : DP[n]);
    }
}
