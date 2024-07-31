
import java.io.*;

class Solution {

    static int T;
    static long N, res;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++){
            N = Long.parseLong(br.readLine());

            res = -1;
            long start = 1;
            long end = (long) Math.sqrt(N << 1);

            while(start <= end) {
                long mid = (start + end) >> 1;
                long num = (mid * (mid + 1)) >> 1;

                if (num == N) {
                    res = mid;
                    break;
                }

                if (num < N) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            sb.append("#").append(tc).append(" ").append(res).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}