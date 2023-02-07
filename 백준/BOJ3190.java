package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ3190 {
    static int N, K, L;
    static int[][] map;
    static List<Pair> snake;
    static HashMap<Integer, String> hash;

    static int sec;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static class Pair{
        int x, y;

        public Pair(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());    // 맵 크기
        K = Integer.parseInt(br.readLine());    // 사과 개수
        sec = 0;   // 초

        map = new int[N][N];
        snake = new LinkedList<>();

        for(int i = 0; i < K; i++) {
           st = new StringTokenizer(br.readLine());
           int x = Integer.parseInt(st.nextToken()) - 1;
           int y = Integer.parseInt(st.nextToken()) - 1;
           map[x][y] = 1;   // 사과 표기
        }

        L = Integer.parseInt(br.readLine());    // 방향 이동 정보
        hash = new HashMap<>();

        for(int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();

            hash.put(cnt, dir);
        }

        Simulation();
        System.out.println(sec);
    }

    public static void Simulation() {
        snake.add(new Pair(0, 0)); // 뱀의 시작점은 0, 0
        int latestX = 0;
        int latestY = 0;

        int idx = 0;
        int directIdx = 0;

        while(true) {
            sec++;

            int nx = latestX + dx[directIdx];
            int ny = latestY + dy[directIdx];

            if(!validation(nx, ny))
                break;

            // 한 칸 앞으로 이동
            snake.add(new Pair(nx, ny));

            // 사과를 먹은 경우 사과 제거
            if(map[nx][ny] == 1) {
                map[nx][ny] = 0;
            }
            // 사과를 먹지 못한경우 꼬리 제거
            else {
                snake.remove(0);
            }

            // 방향이 변해야 하는 시간인 경우
            if(hash.containsKey(sec)) {
                if(hash.get(sec).equals("D")) {
                    directIdx = (directIdx + 1) % 4;
                } else {
                    directIdx = directIdx - 1 < 0 ? 3 : directIdx - 1;
                }
            }

            latestX = nx;
            latestY = ny;
        }
    }

    public static boolean validation(int x, int y){
        // 맵 밖으로 나간 경우
        if(x >= N || y >= N || x < 0 || y < 0)
            return false;

        for(int i = 0; i < snake.size(); i++) {
            // 뱀 몸통과 부딪힌 경우
            if(snake.get(i).x == x && snake.get(i).y == y)
                return false;
        }

        return true;
    }

}
