import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // 다리 길이
        Queue<Integer> bridgeBlock = new LinkedList<>();
        
        // Initializing Bridge
        for (int i = 0; i < bridge_length; i++) {
            bridgeBlock.offer(0);    // 0 - 비어있는 다리 공간
        }
        
        int sec = 0;
        int truckIdx = 0;
        int crossWeight = 0;
        
        while(truckIdx < truck_weights.length) {
            sec++;
            crossWeight -= bridgeBlock.poll();    // 다리를 지난 트럭 무게 -
            
            // 트럭이 다리에 진입할 수 있는 경우
            if (crossWeight + truck_weights[truckIdx] <= weight) {
                bridgeBlock.offer(truck_weights[truckIdx]);
                crossWeight += truck_weights[truckIdx++];
            } else {
                bridgeBlock.offer(0);
            }
        }
        
        return sec + bridge_length;
    }
}