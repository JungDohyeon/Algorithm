package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2644 {
    static List<Integer>[] list;
    static boolean[] visited;

    static int n;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        visited = new boolean[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        ans = -1;

        int m = Integer.parseInt(br.readLine());

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            list[start].add(dest);
            list[dest].add(start);
        }

        Search(a, b, 0);

        System.out.println(ans);
    }

    public static void Search(int start, int dest, int cnt){
        if(start == dest) {
            ans = cnt;
            return;
        }

        visited[start] = true;

        for(int i = 0; i < list[start].size(); i++) {
            int tmp = list[start].get(i);
            if(!visited[tmp])
                Search(tmp, dest, cnt+1);
        }
    }
}
