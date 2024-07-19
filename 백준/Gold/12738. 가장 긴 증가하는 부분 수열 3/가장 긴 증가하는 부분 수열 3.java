
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> list = new ArrayList<>();
        list.add(Integer.MIN_VALUE);

        for (int i = 1; i <= N; i++) {
            int num = arr[i];
            int left = 1;
            int right = list.size() - 1;

            if (num > list.get(right))
                list.add(num);
            else {
                while(left < right) {
                    int mid = (left + right) >> 1;

                    if (list.get(mid) >= num)
                        right = mid;
                    else
                        left = mid + 1;
                }

                list.set(right, num);
            }
        }

        bw.write(String.valueOf(list.size() - 1));
        bw.flush();
        bw.close();
        br.close();
    }
}