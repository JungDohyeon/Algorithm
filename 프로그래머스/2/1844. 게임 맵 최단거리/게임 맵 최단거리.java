import java.util.*;

class Solution {
    static class Axis {
        int x;
        int y;
        
        public Axis(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    static int[][] dist;
    
    public int solution(int[][] maps) {
        dist = new int[maps.length][maps[0].length];
        
        BFS(maps);
        
        return dist[maps.length - 1][maps[0].length - 1] == 0 ? -1 : dist[maps.length - 1][maps[0].length - 1];
    }
    
    private void BFS(int[][] maps) {
        Queue<Axis> q = new LinkedList<>();
        q.add(new Axis(0, 0));
        dist[0][0] = 1;
        
        while(!q.isEmpty()) { 
            Axis p = q.poll();
               
            if (p.x == maps.length - 1 && p.y == maps[0].length - 1) {
                return;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                
                if (nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length)
                    continue;
                
                if (dist[nx][ny] == 0 && maps[nx][ny] == 1) {
                    dist[nx][ny] = dist[p.x][p.y] + 1;
                    q.add(new Axis(nx, ny));
                }
            }
        }
    }
}