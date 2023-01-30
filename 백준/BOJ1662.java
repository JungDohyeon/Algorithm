package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1662 {
    static Stack<Integer> stack;
    static char[] arr;
    static int[] dest;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        arr = str.toCharArray();    // 인덱스 접근으로 쉽게 하기 위해 배열 변환
        dest = new int[arr.length]; // 괄호 출발부터 목적지 정보 저장
        stack = new Stack<>();

        for(int i = 0; i < arr.length; i++) {
            char c = arr[i];

            if(c == '(')
                stack.push(i);
            if(c == ')')
                dest[stack.pop()] = i;
        }

        System.out.println(recur(0, arr.length));
    }

    public static int recur(int left, int right) {
        int len = 0;
        for(int i = left; i < right; i++) {
            if(arr[i] == '(') {
                len += (arr[i-1] - '0') * (recur (i+1, dest[i])) - 1;   // 괄호 내부 처리 - 재귀, -1 : 해당 곱해준 수는 사라지기 때문에 -1
                i = dest[i];    // 괄호 밖 처리
            } else {
                len++;  // 괄호가 아닌 경우 그냥 +1
            }
        }

        return len;
    }
}
