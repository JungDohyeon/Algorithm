import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
       HashMap<String, Integer> hashMap = new HashMap<>();

        // HashMap에 참가자 이름 삽입
        for (String name: participant) {
            hashMap.put(name, hashMap.getOrDefault(name, 0) + 1);
        }

        // 같은 이름이 있으면 -1
        for (String name: completion) {
            hashMap.put(name, hashMap.get(name) - 1);
        }

        String answer = "";

        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() != 0) {
                answer = entry.getKey();
                break;
            }
        }

        return answer;
    }
}