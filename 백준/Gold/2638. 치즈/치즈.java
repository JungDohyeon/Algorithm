
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static private class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    final static int[] dx = {0, 0, 1, -1};
    final static int[] dy = {1, -1, 0, 0};
    final static int AIR_VALUE = 99;

    static int N, M, cheese, timer;
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Node> cheeseList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        cheeseList = new ArrayList<>();
        cheese = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) {
                    cheese++;
                    cheeseList.add(new Node(i ,j));
                }
            }
        }

        timer = 0;

        while(cheese != 0) {
            timer++;
            visited = new boolean[N][M];
            findOuterSpace(new Node(0, 0));
            removeCheese();
        }

        bw.write(String.valueOf(timer));
        bw.flush();
        bw.close();
    }

    static private void findOuterSpace(Node start) {
        visited = new boolean[N][M];
        visited[start.x][start.y] = true;
        map[start.x][start.y] = AIR_VALUE;

        Stack<Node> st = new Stack<>();
        st.push(start);

        while(!st.isEmpty()) {
            Node cur = st.pop();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;

                if (!visited[nx][ny] && map[nx][ny] != 1) {
                    map[nx][ny] = AIR_VALUE;
                    visited[nx][ny] = true;
                    st.push(new Node(nx, ny));
                }
            }
        }
    }

    static private void removeCheese() {
        for (int i = 0; i < cheeseList.size(); i++) {
            int airCnt = 0;

            for (int k = 0; k < 4; k++) {
                int nx = cheeseList.get(i).x + dx[k];
                int ny = cheeseList.get(i).y + dy[k];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;

                if (map[nx][ny] == AIR_VALUE) {
                    airCnt++;
                }
            }

            if (airCnt >= 2) {
                map[cheeseList.get(i).x][cheeseList.get(i).y] = 0;
                cheese--;
                cheeseList.remove(i);
                i--;
            }
        }
    }
}

