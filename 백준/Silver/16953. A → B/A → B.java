import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static Long A, B;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        bw.write(String.valueOf(bfs()));
        bw.flush();
        bw.close();
    }

    private static int bfs() {
        Queue<Long> q = new LinkedList<>();
        q.add(A);

        int count = 0;

        while(!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                long tmp = q.poll();

                if (tmp == B) {
                    return count + 1;
                }

                if (tmp << 1 <= B) {
                    q.add(tmp << 1);
                }

                if (tmp * 10 + 1 <= B) {
                    q.add(tmp * 10 + 1);
                }
            }

            count++;
        }

        return -1;
    }
}
