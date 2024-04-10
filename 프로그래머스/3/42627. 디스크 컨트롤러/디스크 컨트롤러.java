import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        
        // 작업 요청 순서대로 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0]-o2[0]);

        // 우선순위: 작업 필요 시간 짧은 순
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->o1[1]-o2[1]);
        
        int idx = 0;    // job Index
        int cnt = 0;    // 수행 개수
        int timer = 0;
        int jobTotalTime = 0;
        
        while (cnt < jobs.length) {
            
            // 작업 대기열
            while (idx < jobs.length && jobs[idx][0] <= timer) {
                pq.add(jobs[idx++]);
            }
        
            if (pq.isEmpty()) { 
                timer = jobs[idx][0];
            } else {
                int[] nextJob = pq.poll();
                timer += nextJob[1];
                jobTotalTime += timer - nextJob[0];
                cnt++;
            }
        }
     
        return jobTotalTime / jobs.length;
    }
}