import java.util.*;

class Solution {
    static boolean visited[];
    static int max;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        max = 0;
        
        dfs(dungeons, k, 0);
        
        return max;
    }
    
    // 던전 탐험 (DFS)
    public void dfs(int[][] dungeons, int k, int depth) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= k) { 
                visited[i] = true;
                dfs(dungeons, k-dungeons[i][1], depth + 1);
                visited[i] = false;
            }
        }
        
        // 최대 방문 값 갱신
        if (max < depth) {
            max = depth;
        }
    }
}