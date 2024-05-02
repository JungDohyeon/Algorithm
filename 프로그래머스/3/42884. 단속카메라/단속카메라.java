import java.util.*;

class Solution {
        
    public int solution(int[][] routes) {
        int answer = 1; // 첫번째 카메라 무조건 설치
        
        // 진출지점 오름차순 정렬 
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        
        // 진출지점 설정
        int endPoint = routes[0][1];
        
        for (int[] route: routes) {
            
            // 기존 진출 지점 < 새로운 진입 지점
            if (endPoint < route[0] ) {
                endPoint = route[1];
                answer++;
            }
        }
        
        return answer;
    }
}