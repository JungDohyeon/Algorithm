
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] list;
    static int N, root;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        list = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());

            if (parent == -1)
                root = i;
            else {
                list[parent].add(i);
            }
        }

        int remove = Integer.parseInt(br.readLine());
        visited[remove] = true;

        int ans = 0;

        if (remove != root) {
           ans = dfs(root);
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }

    private static int dfs(int node) {
        Stack<Integer> st = new Stack<>();
        st.push(node);
        visited[node] = true;

        int leaf = 0;

        while(!st.isEmpty()) {
            int cur = st.pop();

            int childCnt = 0;

            for (int n: list[cur]) {
                if(!visited[n]) {
                    visited[n] = true;
                    childCnt++;
                    st.push(n);
                }
            }

            if (childCnt == 0)
                leaf++;
        }

        return leaf;
    }
}
