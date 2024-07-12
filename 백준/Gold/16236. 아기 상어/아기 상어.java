
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static class Node {
        int x;
        int y;
        int dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    final static int[] dx = {-1, 1, 0, 0};
    final static int[] dy = {0, 0, -1, 1};

    static int N;
    static int[][] map;
    static int sharkSize = 2;
    static int timer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        Node babyShark = null;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 9) {
                    babyShark = new Node(i, j, 0);
                    map[i][j] = 0;
                }
            }
        }

        bfs(babyShark);

        bw.write(String.valueOf(timer));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs(Node start) {
        Queue<Node> q = new LinkedList<>();
        q.add(start);
        int sharkEat = 0;

        while(true) {
            LinkedList<Node> target = new LinkedList<>();
            int[][] dist = new int[N][N];

            while (!q.isEmpty()) {
                Node cur = q.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N)
                        continue;

                    if (dist[nx][ny] == 0 && map[nx][ny] <= sharkSize) {
                        dist[nx][ny] = dist[cur.x][cur.y] + 1;
                        q.add(new Node(nx, ny, dist[nx][ny]));

                        // 물고기 위치 저장
                        if (map[nx][ny] > 0 && sharkSize > map[nx][ny])
                            target.add(new Node(nx, ny, dist[nx][ny]));
                    }
                }
            }

            if (target.size() == 0) {
                break;
            }

            Node nearestTarget = target.get(0);

            for (Node fish: target) {
                if (nearestTarget.dist > fish.dist) {
                    nearestTarget = fish;
                } else if (nearestTarget.dist == fish.dist) {
                    if(nearestTarget.x > fish.x)
                        nearestTarget = fish;
                    else if(nearestTarget.x == fish.x){
                        if(nearestTarget.y > fish.y)
                            nearestTarget = fish;
                    }
                }
            }

            timer += nearestTarget.dist;
            sharkEat++;

            map[nearestTarget.x][nearestTarget.y] = 0;
            if (sharkEat == sharkSize) {
                sharkSize++;
                sharkEat = 0;
            }

            q.add(new Node(nearestTarget.x, nearestTarget.y, 0));
        }
    }
}