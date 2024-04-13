import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] pattern1 = {1, 2, 3, 4, 5};
        int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] scores = new int[3];
        int highestScore = 0;
        
        for (int num = 0; num < answers.length; num++) { 
            int answer = answers[num];
            
            if (pattern1[num % pattern1.length] == answer) {
                scores[0]++;
            }
            
            if (pattern2[num % pattern2.length] == answer) {
                scores[1]++;
            }
            
            if (pattern3[num % pattern3.length] == answer) {
                scores[2]++;
            }
        }
        
        for (int score: scores) { 
            if (score > highestScore) {
                highestScore = score;
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
         for (int i = 0; i < scores.length; i++) { 
            if (scores[i] == highestScore) {
                list.add(i+1);
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}