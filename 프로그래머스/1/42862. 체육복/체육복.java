import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        HashSet<Integer> reserveNum = new HashSet<>();
        HashSet<Integer> lostNum = new HashSet<>();
        
        for (int studentNum: reserve) { 
            reserveNum.add(studentNum);
        }
        
        // reserve인데 lost에 있는 경우 필터링
        for (int studentNum: lost) { 
            if (reserveNum.remove(studentNum)) {
                answer++;
            } else {
                lostNum.add(studentNum);
            }
        }
        
        // 앞 뒤 번호로 reserve에 있다면 answer++
        for (int studentNum: lostNum) {
             if (reserveNum.contains(studentNum - 1)) {
                reserveNum.remove(studentNum - 1);
                answer++;
            } else if (reserveNum.contains(studentNum + 1)) {
                reserveNum.remove(studentNum + 1);
                answer++;
            } 
        }
        
        return answer;
    }
}