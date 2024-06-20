import java.util.*;

class Solution {
    static int[] dp1;
    static int[] dp2;
    
    public int solution(int[] money) {
        dp1 = new int[money.length];
        dp2 = new int[money.length];
        
        dp1[0] = money[0];
        dp1[1] = dp1[0];
        
        for (int i = 2; i < money.length - 1; i++) {
            dp1[i] = Math.max(dp1[i-2] + money[i], dp1[i-1]); 
        }
        
        dp2[0] = 0;
        dp2[1] = money[1];
        
         for (int i = 2; i < money.length; i++) {
            dp2[i] = Math.max(dp2[i-2] + money[i], dp2[i-1]); 
        }
            
        return Math.max(dp1[money.length - 2], dp2[money.length - 1]);
    }
}