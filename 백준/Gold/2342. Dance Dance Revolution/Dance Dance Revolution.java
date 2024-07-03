
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer> list;
    static int size;
    static int[][][] dp;
    static int[][] step = {
        {1, 2, 2, 2, 2},
        {0, 1, 3, 4, 3},
        {0, 3, 1, 3, 4},
        {0, 4, 3, 1, 3},
        {0, 3, 4, 3, 1}
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        list = new ArrayList<>();

        while (true) {
            int n = Integer.parseInt(st.nextToken());

            if(n == 0) {
                break;
            }

            list.add(n);
        }

        size = list.size();

        dp = new int[size][5][5];

        bw.write(String.valueOf(solution(0, 0, 0)));
        bw.flush();
        bw.close();
    }

    private static int solution(int idx, int left, int right) {
        if(idx == size)
            return 0;

        if (dp[idx][left][right] != 0) {
            return dp[idx][left][right];
        }

        int next = list.get(idx);

        dp[idx][left][right] = Math.min(
                solution(idx + 1, next, right) + step[left][next],  // 왼발
                solution(idx + 1, left, next) + step[right][next]   // 오른발
        );

        return dp[idx][left][right];
    }
}
