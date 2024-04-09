import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int max = nums.length / 2;  // 최대 가질 수 있는 개수
        
        // Set으로 중복 제거
        HashSet<Integer> hashSet = new HashSet<>();
        
        for(int i: nums) { 
            hashSet.add(i);
        }
        
        if (max > hashSet.size()) {  
            return hashSet.size();
        } else {
            return max;
        }
    }
}