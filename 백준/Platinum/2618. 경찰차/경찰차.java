
import java.io.*;
import java.util.*;

public class Main {
    static int N, W;
    static int[][] dp = new int[1002][1002];
    static int[][] position = new int[1002][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        W = Integer.parseInt(br.readLine());

        for(int i = 1; i <= W; i++) {
            st = new StringTokenizer(br.readLine());

            position[i][0] = Integer.parseInt(st.nextToken());
            position[i][1] = Integer.parseInt(st.nextToken());
        }

        bw.write(policeEvent(1,0,0)+"\n");

        int firstIdx = 0;
        int secondIdx = 0;

        for(int i = 1; i <= W; i++) {
            int dist1 = getDist(1, firstIdx, i);

            if(dp[firstIdx][secondIdx] - dist1 == dp[i][secondIdx]) {
                firstIdx = i;
                bw.write("1\n");
            }else {
                secondIdx = i;
                bw.write("2\n");
            }
        }

        bw.flush();
        bw.close();
    }

    private static int policeEvent(int event, int first, int second) {
        if(event > W)
            return 0;

        if(dp[first][second] != 0)
            return dp[first][second];

        int firstDist = policeEvent(event+1, event, second) + getDist(1, first, event);
        int secondDist = policeEvent(event+1, first, event) + getDist(2, second, event);

        dp[first][second] = Math.min(firstDist, secondDist);

        return dp[first][second];
    }

    private static int getDist(int police, int start, int end) {
        int x_start = position[start][0];
        int y_start = position[start][1];
        int x_end = position[end][0];
        int y_end = position[end][1];

        if(start == 0) {
            if(police == 1)
                x_start = y_start = 1;
            else
                x_start = y_start = N;
        }

        return Math.abs(x_start - x_end) + Math.abs(y_start - y_end);
    }
}
