class Solution {
    public int solution(int[][] sizes) {
        int min = 1;
        int max = 1;
        
        for (int[] rect: sizes) {
            max = Math.max(max, Math.max(rect[0], rect[1]));
            min = Math.max(min, Math.min(rect[0], rect[1]));
        }
        
        return min*max;
    }
}