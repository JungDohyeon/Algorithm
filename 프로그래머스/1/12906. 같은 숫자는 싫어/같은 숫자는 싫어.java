import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
       ArrayList<Integer> list = new ArrayList<Integer>();

        int preValue = 10;  // 0~9 조건이므로 10으로 초기화
        
        for(int n : arr) {
            if(preValue != n)
                list.add(n);
            
            preValue = n;
        }
        
        int arrSize = list.size(); 
        
        int[] answer = new int[arrSize];
        
        for(int i=0; i<arrSize; i++) {
            answer[i] = list.get(i).intValue();
        }
        
        return answer;
    }
}