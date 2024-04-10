import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        int answer = 1;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String[] wear: clothes) { 
            map.put(wear[1], map.getOrDefault(wear[1], 0) + 1);
        }
        
        Iterator<Map.Entry<String, Integer>> entrySet =
            map.entrySet().iterator();
        
        // 모든 조합의 경우의 수 구하기
        while (entrySet.hasNext()) {
            Map.Entry<String, Integer> element = entrySet.next();
            answer *= element.getValue() + 1;   // 해당 종류의 옷을 안입을 수 있기 때문에 + 1
        }
        
        // 옷을 한 개도 안입는 경우 뺴고 리턴
        return answer - 1;
    }
}