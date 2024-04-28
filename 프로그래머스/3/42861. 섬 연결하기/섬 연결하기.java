import java.util.*;

class Solution {
    static int[] parentNode;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        parentNode = new int[n];
        
        for (int i = 0; i < n; i++) { 
            parentNode[i] = i;  // Union find 전처리
        }
        
        // 간선 값 작은 것부터 정렬 (Greedy)
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        
        for (int[] cost: costs) {
            // Union find
            if (find(cost[0]) != find(cost[1])) { 
                union(cost[0], cost[1]);
                answer += cost[2];
            }
        }
        
        return answer;
    }
    
    private int find(int n) { 
        if (parentNode[n] == n) { 
            return n;
        } else {
            return find(parentNode[n]);
        }
    }
    
    private void union(int x, int y) { 
        x = find(x);
        y = find(y);
        
        if (x != y) { 
            parentNode[y] = x;
        }
    }
}