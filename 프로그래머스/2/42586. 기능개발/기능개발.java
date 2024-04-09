import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        // 작업 완료 날짜 우선순위 비교를 위해 Queue 사용 (stack은 LIFO로 나중 값이 비교됨.)
        Queue<Integer> q = new LinkedList<Integer>();   
        
        int progressCount = progresses.length;
        
        // 배포 우선 순위대로 들어오기 때문에 i자체로 배포 우선 순위.
        for (int i = 0; i < progressCount; i++) { 
            double remain = (100 - progresses[i]) / (double) speeds[i];
            int remainDays = (int) Math.ceil(remain);   // 작업 완료까지 남은 일 수
            
            // empty 스택: 같은 날 배포 될 것이 없음
            // remainDays > st.peek(): 스택에 존재하는 기능보다 이후 배포
            if (!q.isEmpty() && (remainDays > q.peek())) { 
                list.add(q.size());
                q.clear();
            }
            
            q.add(remainDays);
        }
        
        // 잔여 기능 배포
        list.add(q.size());
        
        int ansSize = list.size();
        int[] answer = new int[ansSize];
        for (int i = 0; i < ansSize; i++) {
            answer[i] = list.get(i).intValue();
        }

        return answer;
    }
}