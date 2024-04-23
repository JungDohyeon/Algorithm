import java.util.*;

class Solution {
    public String solution(String number, int k) {
        
        int len = number.length();
        
        int idx = 0;    // 문자열 검색 인덱스
        int maxIdx = 0;
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < len - k; i++) { 
            int maxValue = 0;   // 가장 큰 수 확인
            
            for (int j = idx; j < i + k + 1; j++) {
                int curValue = number.charAt(j) - '0';
                
                if (maxValue < curValue) { 
                    maxValue = curValue;
                    maxIdx = j;   
                }
            }
            
            sb.append(maxValue);
            idx = maxIdx + 1;
        }
        
        return sb.toString();
    }
}