import java.util.*;

class Solution {
    static ArrayList<String> travelList;
    static boolean[] visited;
        
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        travelList = new ArrayList<>();
        
        dfs("ICN", "ICN", 0, tickets);
        
        Collections.sort(travelList);
        
        return travelList.get(0).split("/");
    }
    
    private void dfs(String region, String travelPath, int depth, String[][] tickets) { 
        int maxDepth = tickets.length;
        
        if (depth == maxDepth) {
            travelList.add(travelPath);
            return;
        }
        
        for (int i = 0; i < maxDepth; i++) {
            // 방문하지 않고 현재 지역이 티켓에 있다면
            if (!visited[i] && region.equals(tickets[i][0])) {
                visited[i] = true;
                dfs(tickets[i][1], travelPath + "/" + tickets[i][1], depth + 1, tickets);
                visited[i] = false;
            }
        }
    }
}