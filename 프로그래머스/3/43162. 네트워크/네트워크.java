import java.util.*;

class Solution {
    boolean[] visited;
    int answer;
    
    public int solution(int n, int[][] computers) {
        answer = 0;
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                DFS(i, computers);
            }
        }
        
        return answer;
    }
    
    public void DFS(int startNode, int[][] computers) { 
        Stack<Integer> st = new Stack<>();
        st.push(startNode);
        visited[startNode] = true;
        
        while(!st.isEmpty()) {
            int num = st.pop();
            
            for (int i = 0; i < visited.length; i++) { 
                if (!visited[i] && computers[num][i] == 1) {
                    visited[i] = true;
                    st.push(i);
                }
            }
        }
    }
}