
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    private static class Node {
        int x;
        int y;

        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    final static int[] dx = {0, 0, 1, -1};
    final static int[] dy = {1, -1, 0, 0};

    static int N, M;
    static int[][] map, group;
    static Map<Integer, Integer> groupMap;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        group = new int[N][M];
        groupMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        int groupId = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0 && group[i][j] == 0) {
                    groupMap.put(groupId, bfs(new Node(i, j), groupId));
                    groupId++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(counter(i, j));
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int counter(int x, int y) {
        int res = 1;
        HashSet<Integer> set = new HashSet<>();

        if (map[x][y] == 0)
            return 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M || group[nx][ny] == 0)
                continue;

            if(map[nx][ny] == 0)
                set.add(group[nx][ny]);
        }

        for (int id: set) {
            res += groupMap.get(id);
        }

        return res % 10;
    }

    private static int bfs(Node start, int id) {
        Queue<Node> q = new LinkedList<>();
        q.add(start);
        group[start.x][start.y] = id;
        int cnt = 1;

        while(!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;

                if (map[nx][ny] == 0 && group[nx][ny] == 0) {
                    cnt++;
                    group[nx][ny] = id;
                    q.offer(new Node(nx, ny));
                }
            }
        }

        return cnt;
    }
}