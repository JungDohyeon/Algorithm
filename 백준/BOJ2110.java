package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2110 {
    static int[] arr;
    static int N, C;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        ans = 0;

        arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        binarySearch(1, arr[N-1] - arr[0]); // 최소 거리 1 ~ 최대 거리

        System.out.println(ans);
    }

    static void binarySearch(int start, int end) {
        int dist = 0;
        while(start <= end) {
            int install = arr[0];   // 가장 왼쪽 집 설치
            int cnt = 1; // 맨 왼쪽에 설치한 개수
            int mid = (start + end) >> 1;

            for(int i = 1; i < N; i++) {
                dist = arr[i] - install;    // 직전 설치된 집과 다음 집까지의 거리
                // 거리가 해당 기준보다 멀거나 같다면 설치
                if(dist >= mid) {
                    cnt++;
                    install = arr[i];
                }
            }

            // 더 많이 설치된 경우 거리를 늘린다.
            if(cnt >= C) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }
}
