import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int ans;
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ans = Integer.MAX_VALUE;
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            ans = 0;
        } else {
            BFS(N);
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }

    private static void BFS(int start) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{start, 0});
        visited[start] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            int step = cur[0];
            int time = cur[1];

            if(step == K) {
                ans = Math.min(time, ans);
            }

            if((step << 1) < 100001 && !visited[step << 1]) {
                visited[step << 1] = true;
                q.add(new int[]{step << 1, time});
            }

            int next = step - 1;
            if(next >= 0 && !visited[next]) {
                visited[next] = true;
                q.offer(new int[]{next, time + 1});
            }

            next = step + 1;
            if(next < 100001 && !visited[next]) {
                visited[next] = true;
                q.offer(new int[]{next, time + 1});
            }
        }
    }
}
