package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon1773 {
    static boolean[] arr;
    static int num, time, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        num = Integer.parseInt(st.nextToken());
        time = Integer.parseInt(st.nextToken());
        arr = new boolean[time + 1];
        for (int i = 0; i <= time; i++) {
            arr[i] = false;
        }

        ans = 0;
        for (int i = 0; i < num; i++) {
            int period = Integer.parseInt(br.readLine());
            for (int j = period; j <= time; j += period) {
                if (!arr[j]) {
                    arr[j] = true;
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}

