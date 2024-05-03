import java.util.*;

class Solution { 
    static int answer;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        dfs(numbers, 0, target, 0);
        
        return answer;
    }
    
    private void dfs(int[] numbers, int sum, int target, int depth) {
        if(depth == numbers.length) {
            if(target == sum) 
                answer++;
        } else {
            dfs(numbers, sum + numbers[depth], target, depth + 1);
            dfs(numbers, sum - numbers[depth], target, depth + 1);
        }
    }
}