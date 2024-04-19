import java.util.*;

class Solution {
    static int wireCount;
    static boolean[][] wireMap;
    
    public int solution(int n, int[][] wires) {
        wireCount = n;
        int answer = n;
        
        wireMap = new boolean[n+1][n+1];
        
        // 간선 연결
        for(int[] wire: wires) {
            wireMap[wire[0]][wire[1]] = true;
            wireMap[wire[1]][wire[0]] = true;
        }
        
        for(int[] wire: wires) {
            // 간선 제거
            wireMap[wire[0]][wire[1]] = false;
            wireMap[wire[1]][wire[0]] = false;
            
            answer = Math.min(answer, dfs(wires[0][0]));

            // 간선 복구
            wireMap[wire[0]][wire[1]] = true;
            wireMap[wire[1]][wire[0]] = true;    
        }
        
        return answer;
    }
    
    private int dfs(int wireNum) {
        boolean[] visited = new boolean[wireCount+1];
        
        int cnt = 1;
        
        Stack<Integer> st = new Stack<>();
        visited[wireNum] = true;
        st.push(wireNum);
        
        while(!st.isEmpty()) { 
            int tmp = st.pop();
            
            for (int next = 1; next <=wireCount; next++) {
                if(!visited[next] && wireMap[tmp][next]) {
                    visited[next] = true;
                    st.push(next);
                    cnt++;
                }
            }
        }
        
        // 연결된 송전탑 차이 (cnt, wireCount-cnt)
        return Math.abs((cnt<<1) - wireCount);
    }
}