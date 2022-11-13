package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class BackJoon1003 {
    static int row;
    static int col;
    static int[][] ground; // 배추 밭 크기
    static boolean[][] visited; // 방문 여부 확인
    static int[] moveX = {0,1,0,-1};
    static int[] moveY = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i<n; i++){
            int count = 0;
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            ground = new int [row][col];
            visited = new boolean[row][col];
            for (int loop = 0; loop<k; loop++){
                String spot = br.readLine();
                st = new StringTokenizer(spot, " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                ground[x][y] = 1;
            }
            for(int a=0; a<row; a++){
                for(int b=0; b<col; b++){
                    if(ground[a][b]==1 && !visited[a][b]){  // 배추가 있고 방문하지 않았다면 dfs
                        dfs(a,b);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    // dfs
    static  void dfs(int x, int y){
        visited[x][y] = true;   // 방문 확인
        for (int i = 0; i<4; i++){
            int adjacentX = x + moveX[i];
            int adjacentY = y + moveY[i];
            if(adjacentX >= 0 && adjacentY >= 0 && adjacentX < row && adjacentY < col) {
                if (ground[adjacentX][adjacentY] == 1 && !visited[adjacentX][adjacentY]) {
                    dfs(adjacentX, adjacentY);
                }
            }
        }
    }
}
