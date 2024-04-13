import java.util.*;

class Solution {
    static HashSet<Integer> set;
    static boolean[] visited;
    static int strLen;
    
    public int solution(String numbers) {
        strLen = numbers.length();
        set = new HashSet<>();
        visited = new boolean[strLen];  
        
        dfs(numbers, "", 0);    // dfs로 모든 조합 탐색
        
        int answer = 0;
        
        for(int num: set) { 
            if (isPrime(num)) {
               answer++; 
            }
        }
        
        return answer;
    }
    
    // 문자열 조합
    private void dfs(String numbers, String str, int depth) {
        if (depth > strLen) { 
            return;
        }
        
        for(int i = 0; i < strLen; i++) {
            if (!visited[i]) { 
                visited[i] = true;
                set.add(Integer.parseInt(str + numbers.charAt(i)));
                dfs(numbers, str + numbers.charAt(i), depth + 1);
                visited[i] = false;
            }
        }
    }
    
    // 소수 판별 (에라토스테네스의 체)
    private boolean isPrime(int n) { 
        if (n < 2) { 
            return false;
        }
        
        for (int i = 2; i <= (int) Math.sqrt(n); i++) { 
            if (n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}