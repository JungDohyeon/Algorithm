
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[] timeMap;
    static int ans = 987654321;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N >= K) {
            bw.write((N-K) + "\n" + "1");
        } else {
            timeMap = new int[100001];
            bfs();

            bw.write(ans + "\n" + count);
        }
        bw.flush();
        bw.close();
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        timeMap[N] = 1;

        while(!q.isEmpty()) {
            int cur = q.poll();

            if (ans < timeMap[cur])
                return;

            for (int i = 0; i < 3; i++) {
                int next = step(i, cur);

                if (next < 0 || next > 100000)
                    continue;

                if (next == K) {
                    ans = timeMap[cur];
                    count++;
                }

                if (timeMap[next] == 0 || timeMap[next] == timeMap[cur] + 1) {
                    q.add(next);
                    timeMap[next] = timeMap[cur] + 1;
                }
            }
        }
    }

    private static int step(int type, int n) {
        switch (type) {
            case 0:
                return n + 1;
            case 1:
                return n - 1;
            case 2:
                return n << 1;
        }

        return 0;
    }
}

