import java.util.*;

class Solution {
    boolean solution(String s) {
        int indicator = 0;
        int stringLen = s.length();
        
        for (int i = 0; i < stringLen; i++) { 
            if (s.charAt(i) == '(') { 
                indicator++;
            } else {
                indicator--;
            }
            
            if (indicator < 0)
                return false;
        }

        if (indicator == 0) { 
            return true;
        } else {
            return false;
        }
    }
}