import java.util.*;

class Solution {
    
    static List<HashSet<Integer>> dp;
    
    public int solution(int N, int number) {
        initializer(N);
        
        if (number == N) { 
            return 1;
        }
        
        for (int i = 2; i <= 8; i++) { 
            HashSet<Integer> temp = dp.get(i);
            
            for (int j = 1; j < i; j++) { 
                temp.add(unionNumber(N, i));
                
                HashSet<Integer> curSet = dp.get(j);
                HashSet<Integer> beforeSet = dp.get(i-j);
                
                for (int a: curSet) { 
                    for (int b: beforeSet) { 
                        temp.add(a+b);
                        
                        if (a >= b) {
                            temp.add(a-b);
                        }
                        
                        temp.add(a*b);
                        
                        if (a != 0 && b != 0 && a >= b) { 
                          temp.add(a/b);
                        }
                    }
                }
            }
                
            if (temp.contains(number)) {
                return i;
            }
        }
        
        return -1;
    }
    
    private void initializer(int N) { 
       dp = new LinkedList<>();
        
        for (int i = 0; i < 9; i++) {
            dp.add(new HashSet<>());
        }
        
        dp.get(1).add(N);
    }
    
    private int unionNumber(int n, int len) { 
        int unionNum = n;
        
        for (int i = 1; i < len; i++) { 
            unionNum = unionNum * 10 + n;
        }
        
        return unionNum;
    }
}