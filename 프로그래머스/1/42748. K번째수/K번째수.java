import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int arrLen = commands.length;
        int[] answer = new int[arrLen];

        for (int i = 0; i < arrLen; i++) {
            // 조건에 맞는 배열 추출
            int[] copyArr = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            
            // 배열 정렬
            Arrays.sort(copyArr);
            
            answer[i] = copyArr[commands[i][2] - 1];
        }

        return answer;
    }
}