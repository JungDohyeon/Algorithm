import java.util.*;

class Solution {
    static int answer;
    static boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        answer = 0;
        visited = new boolean[words.length];
        
        if(Arrays.asList(words).contains(target)) {
            dfs(begin, target, words, 0);
            return answer;
        } else {
            return 0;
        }
    }
    
    private void dfs(String begin, String target, String[] words, int cnt) { 
        if (begin.equals(target)) {
            answer = cnt;
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            if(!visited[i] && availableConvert(begin, words[i])) {
                visited[i] = true;
                dfs(words[i], target, words, cnt + 1);
                visited[i] = false;
            }
        }
    }
    
    private boolean availableConvert(String w1, String w2){
        int diff = 0;
        
        for (int i = 0; i < w1.length(); i++){
            if (w1.charAt(i) != w2.charAt(i)){
                diff++;
            }
        }
        
        return diff == 1;
    }
}