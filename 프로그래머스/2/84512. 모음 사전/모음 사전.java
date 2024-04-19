import java.util.*;

class Solution {
    static int cnt;
    static int answer;
    static String target;
    static char[] alphabet = {'A', 'E', 'I', 'O', 'U'};
    
    public int solution(String word) {
        cnt = 0;
        answer = 0;
        target = word;
        
        dfs("");
        
        return answer;
    }
    
    private void dfs(String str) {
        // 찾는 단어인 경우
        if (str.equals(target)) {
            answer = cnt;
            return;
        }
        
        // 최대 길이면 리턴
        if (str.length() == 5) {
            return;
        }
        
        for(char alpha: alphabet) {
            cnt++;
            dfs(str + alpha);
        }
    }
}