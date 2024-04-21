import java.util.*;

class Solution {
    public int solution(String name) {
        int skipAlpha = 0;
        int answer = 0;
        int len = name.length();
        int moveCnt = len - 1;
        
        for(int i=0;i<name.length();i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            skipAlpha = i + 1;
            
            while(skipAlpha < name.length() && name.charAt(skipAlpha) == 'A') {
                skipAlpha++;
            }
            
            // 정방향 탐색
            moveCnt = Math.min(moveCnt, (i<<1) + len - skipAlpha);
            
            // 역방향 탐색
            moveCnt = Math.min(moveCnt, ((len - skipAlpha)<<1) + i);
        }
        
        return answer + moveCnt;
    }
}