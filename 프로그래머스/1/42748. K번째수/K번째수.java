import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int arrLen = commands.length;
        int[] answer = new int[arrLen];

        for (int i = 0; i < arrLen; i++) {
            // 조건에 맞는 배열 추출
            int[] copyArr = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            
            // 배열 정렬
            quickSort(copyArr, 0, copyArr.length-1);
            
            answer[i] = copyArr[commands[i][2] - 1];
        }

        return answer;
    }
    
    private void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        
        int mid = partition(arr, left, right);
        quickSort(arr, left, mid - 1);
        quickSort(arr, mid, right);
    }
    
    private int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        
        while (left <= right) { 
            while(arr[left] < pivot)
                left++;
            
            while(arr[right] > pivot) 
                right--;
            
            if (left <= right) { 
                swap(arr, left++, right--);
            }
        }
    
        return left;
    }
    
    private void swap(int[] arr, int a, int b) { 
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
