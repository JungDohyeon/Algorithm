
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] num, operator;

    static int maxVal, minVal;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        num = new int[N];
        operator = new int[4];
        maxVal = Integer.MIN_VALUE;
        minVal = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(num[0], 1);

        System.out.println(maxVal);
        System.out.println(minVal);
    }

    private static void dfs(int sum, int idx) {
        if (idx == N) {
            maxVal = Math.max(maxVal, sum);
            minVal = Math.min(minVal, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;

                switch (i) {
                    case 0:
                        dfs(sum + num[idx], idx + 1);
                        break;
                    case 1:
                        dfs(sum - num[idx], idx + 1);
                        break;
                    case 2:
                        dfs(sum * num[idx], idx + 1);
                        break;
                    case 3:
                        dfs(sum / num[idx], idx + 1);
                        break;
                }

                operator[i]++;
            }
        }
    }
}
