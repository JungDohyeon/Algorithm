import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        // 우선순위를 판별할 PQ 생성 (큰 수가 상위 우선순위)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        
        // 인덱스 순서로 들어가기 때문에 순서 보장
        for (int prior: priorities) { 
            pq.add(prior);
        }
        
        while(!pq.isEmpty()) {
            int size = priorities.length;
            
            for (int i = 0; i < size; i++) { 
                // 현재 최상위 우선순위 값이라면 PQ에서 제거
                if (priorities[i] == pq.peek()) { 
                    pq.poll();
                    answer++;
                    
                    // 찾고자 하는 위치였다면 Return
                    if (i == location) { 
                        return answer;
                    }
                }
            }
        }
        
        return answer;
    }
}