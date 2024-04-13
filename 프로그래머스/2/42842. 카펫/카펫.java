import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int totalBlock = brown + yellow;
        
        for (int width = totalBlock>>1 - 1; width > 0; width--) { 
            if (totalBlock % width != 0) 
                continue;
            
            int height = totalBlock / width;
            
            if ((width - 2) * (height - 2) == yellow) {
                answer[0] = width;
                answer[1] = height;
                break;
            }
        }
        
        return answer;
    }
}