package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon10090 {
    static int[] tmp;
    static int[] arr;
    static long inversion;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N  = Integer.parseInt(br.readLine());   // 순열 길이
        arr = new int[N];
        tmp = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        inversion = 0;

        mergeSort(0, N-1);

        System.out.println(inversion);
    }

    static void mergeSort(int start, int end) {
        if (start >= end)   // 모두 분할 한 경우 끝
            return;

        int mid = (start + end) >> 1; // 중앙 값
        mergeSort(start, mid);  // 좌측
        mergeSort(mid+1, end);  // 우측
        merge(start, end);  // 병합
    }

    static void merge(int left, int right) {
        int mid = (left + right) >> 1;
        int leftIdx = left;     // 좌측 배열 인덱스
        int rightIdx = mid+1;   // 우측 배열 인덱스
        int tempIdx = left;     // 임시 배열 인덱스

        // 허용 인덱스 범위 내에 있을 경우에만 허용
        while(leftIdx <= mid || rightIdx <= right) {
            if(rightIdx > right || (leftIdx <= mid && arr[leftIdx] <= arr[rightIdx])) {
                tmp[tempIdx++] = arr[leftIdx++];
            } else {
                inversion += (mid - leftIdx + 1);
                tmp[tempIdx++] = arr[rightIdx++];
            }
        }

        // copy array
        for(int i = left; i<=right; i++) {
            arr[i] = tmp[i];
        }
    }
}
