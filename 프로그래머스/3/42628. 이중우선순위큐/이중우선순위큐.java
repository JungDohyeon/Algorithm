import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> highPrior = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> lowPrior = new PriorityQueue<>();
        StringTokenizer st;
        
        for (String operation: operations) {
            st = new StringTokenizer(operation);
            char op = st.nextToken().charAt(0);
            int val = Integer.parseInt(st.nextToken());
            
            // Insert Queue
            if (op == 'I') { 
                highPrior.add(val);
                lowPrior.add(val);
            }
            // Delete Queue
            else {
                if (highPrior.isEmpty())
                    continue;
                    
                if (val == 1) {
                    int delValue = highPrior.poll();
                    lowPrior.remove(delValue);
                } else {
                    int delValue = lowPrior.poll();
                    highPrior.remove(delValue);
                }
            }
            
        }
        
        int[] answer = new int[2];
        
        if (!highPrior.isEmpty()) { 
            answer[0] = highPrior.peek();
            answer[1] = lowPrior.peek();
        }
        
        return answer;
    }
}