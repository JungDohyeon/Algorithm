import java.io.*;
import java.util.PriorityQueue;

class Solution {

    final static int[] dx = {1, -1, 0, 0};
    final static int[] dy = {0, 0, 1, -1};

    static int T, N, ans;
    static int[][] map;
    static boolean[][] visited;

    static class Node implements Comparable<Node>{
        int x;
        int y;
        int time;

        public Node(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.time, o.time);
        }
    }

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            N = Integer.parseInt(br.readLine());
            ans = Integer.MAX_VALUE;

            map = new int[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                String str = br.readLine();

                for (int j = 0; j < N; j++) {
                    map[i][j] = str.charAt(j) - '0';
                }
            }

            bfs(0, 0);

            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void bfs(int x, int y) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        visited[x][y] = true;
        pq.add(new Node(x, y, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if(cur.x == N - 1 && cur.y == N - 1) {
                ans = Math.min(ans, cur.time);
            }

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N)
                    continue;

                if(!visited[nx][ny]) {
                    pq.add(new Node(nx, ny, cur.time + map[nx][ny]));
                    visited[nx][ny] = true;
                }
            }
        }
    }
}