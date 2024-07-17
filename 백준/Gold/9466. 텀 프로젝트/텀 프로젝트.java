import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int T, N;
    static int[] arr;
    static boolean[] visited, done;
    static int cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N + 1];
            visited = new boolean[N + 1];
            done = new boolean[N + 1];
            cnt = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());

                if (i == arr[i]) {
                    done[i] = true;
                    cnt++;
                }
            }

            for (int i = 1; i <= N; i++) {
                if (!done[i]) {
                    dfs(i);
                }
            }

            sb.append(N-cnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int start) {
        if(visited[start]) {
            done[start] = true;
            cnt++;
        } else {
            visited[start] = true;
        }

        if(!done[arr[start]]) {
            dfs(arr[start]);
        }

        visited[start] = false;
        done[start] = true;
    }
}