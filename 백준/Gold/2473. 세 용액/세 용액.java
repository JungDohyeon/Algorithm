
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static long[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        long answer = Long.MAX_VALUE;

        int[] idx = new int[3];
        
        for (int i = 0; i < N - 2; i++) {
            int start = i;
            int mid = i + 1;
            int end = N - 1;

            while(mid < end) {
                long sum = arr[start] + arr[mid] + arr[end];

                if (answer > Math.abs(sum)) {
                    answer = Math.abs(sum);
                    idx[0] = start;
                    idx[1] = mid;
                    idx[2] = end;
                }

                if (sum == 0) {
                    break;
                }

                if(sum > 0) {
                  end--;
                } else {
                    mid++;
                }
            }
        }

        bw.write(arr[idx[0]] + " " + arr[idx[1]] + " " + arr[idx[2]]);

        bw.flush();
        bw.close();
        br.close();
    }
}