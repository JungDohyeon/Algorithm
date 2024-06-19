import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        
        long left = times[0];
        long right = times[times.length - 1] * (long)n;
        
        long answer = Long.MAX_VALUE;
        
        while(left <= right) {
            long mid = (left + right) >> 1;
            long timeSum = 0;
            
            for (int time: times) { 
                timeSum += mid / time;
            }
            
            if (timeSum < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = Math.min(answer, mid);
            }
        }  
        return answer;
    }
}