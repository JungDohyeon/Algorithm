import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < prices.length; i++) {
            // 감소 시점 (수 역전되는 순간)
            while(!st.isEmpty() && prices[st.peek()] > prices[i]) {
                answer[st.peek()] = i - st.pop();   // 시간 경과 계산
            }
                
            st.push(i);
        }
        
        // 끝까지 감소하지 않은 수 처리
        while(!st.isEmpty()) { 
            answer[st.peek()] = prices.length - st.pop() - 1;
        }
        
        return answer;
    }
}