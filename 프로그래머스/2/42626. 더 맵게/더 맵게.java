import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {  
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // PQ 데이터 삽입
        for (int value: scoville) { 
            pq.add(value);
        }
        
        // 최소값 셋팅 (scoville 최소 크기가 2이므로 Null 검사 X)
        int lowestValue = pq.peek();
        
        while(lowestValue < K) {
            if(pq.size() < 2) { 
                return -1;
            }
            
            pq.add(mixScoville(pq.poll(), pq.poll()));
            lowestValue = pq.peek();    // 최소값 갱신
            answer++;
        }
        
        return answer;
    }
    
    public int mixScoville(int a, int b) { 
        return a + b * 2;
    }
}