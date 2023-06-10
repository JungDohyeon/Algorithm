package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ20924 {

    private static class Node {
        int n, d;

        public Node(int n, int d) {
            this.n = n;
            this.d = d;
        }
    }

    static ArrayList<Node>[] adj;
    static boolean[] visited;
    static int gigaNode;
    static int max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int n = 1; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            adj[a].add(new Node(b, d));
            adj[b].add(new Node(a, d));
        }

        long treeH = getTreeHeight(R, 0);
        long longestL = getLeafLen(gigaNode, 0);
        System.out.println(treeH + " " + longestL);

    }

    static int getLeafCnt(int node) {
        int cnt = 0;
        for (Node next: adj[node]) {
            if(!visited[next.n])
                cnt++;
        }
        return cnt;
    }

    static int getLeafLen (int root, int len) {
        if (getLeafCnt(root) == 0)
            return len;

        for(Node next: adj[root]) {
            if(!visited[next.n]) {
                visited[next.n] = true;
                max = Math.max(max, getLeafLen(next.n, next.d + len));
            }
        }

        return max;
    }

    static int getTreeHeight(int root, int len) {
        visited[root] = true;

        if (getLeafCnt(root) != 1) {
            gigaNode = root;
            return len;
        }
        else {
            for (Node next: adj[root]) {
                if(!visited[next.n]) {
                    return getTreeHeight(next.n, len + next.d);
                }
            }
        }
        return -1;
    }
}
