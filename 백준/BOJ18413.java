package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ18413 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Stack<Character> st = new Stack<>();

        String str = br.readLine(); // 문자열 입력
        boolean isIn = false;
        int len = str.length();

        for(int i = 0; i < len; i++) {
            // < 를 반났을 때 이전 값 역순 출력
            if(str.charAt(i) == '<') {
                // 이전 값 역순 출력
                while(!st.isEmpty()) {
                    sb.append(st.pop());
                }
                // flag 변경
                isIn = true;
            } else if(str.charAt(i) == '>') {
                sb.append(str.charAt(i));
                isIn = false;
                continue;
            }

            // 괄호 안 or 괄호 밖
            if (isIn) {
                sb.append(str.charAt(i));
            } else {
                // spacebar를 만난 경우 이전 값 역순 출력
                if(str.charAt(i) == ' ') {
                    while (!st.isEmpty()) {
                        sb.append(st.pop());
                    }
                    sb.append(' ');
                } else {
                    st.push(str.charAt(i));
                }
            }

            // 마지막 부분에서 남은 문자 출력
            if (i == len - 1) {
                while(!st.isEmpty()) {
                    sb.append(st.pop());
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
