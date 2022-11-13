package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon1052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line," ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int ans = 0;

        if(n <= k){
            ans = 0;
        } else {
            while (bottleCheck(n) > k) {
                ans++;
                n++;
            }
        }
        System.out.println(ans);
    }

    static int bottleCheck(int k){
        int count = 0;
        while(k>0){
            if(k%2 == 1){
                count++;
            }
            k /= 2;
        }
        return count;
    }
}
