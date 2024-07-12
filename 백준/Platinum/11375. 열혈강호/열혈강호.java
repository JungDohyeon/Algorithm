
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static ArrayList<Integer>[] list;
    static int[] task;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        task = new int[M + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());

            for (int j = 0; j < cnt; j++) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            visited = new boolean[M + 1];

            if(dfs(i))
                cnt++;
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean dfs(int peopleNum) {
        for (int next: list[peopleNum]) {
            if (visited[next])
                continue;

            visited[next] = true;

            if(task[next] == 0 || dfs(task[next])) {
                task[next] = peopleNum;
                return true;
            }
        }

        return false;
    }
}