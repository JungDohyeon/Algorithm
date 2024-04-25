import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        
        Arrays.sort(people);
        
        int boat = 0;
        int left = 0;
        int right = people.length - 1;
        
        while (left <= right) {
            int partSum = people[left++] + people[right--];
            
            if (partSum > limit) {
                left--;
            }
            
            boat++;
        }
        
        if (left == right) {
            boat++;
        }
        
        return boat; 
    }
}