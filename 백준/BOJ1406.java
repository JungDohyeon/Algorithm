package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

// 연결리스트를 사용해서 풀면 삽입과 삭제 연산이 O(n)이되기 때문에 시간초과 발생 -> O(1)로 삽입, 삭제 연산을 하려고 한다 -> Stack 두 개를 사용하여 표현

public class BOJ1406 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine(); // 문자열
        int len = str.length();
        int N = Integer.parseInt(br.readLine());    // 명령어 개수

        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();

        for(int i = 0; i < len; i++) {
            st1.push(str.charAt(i));
        }

        int listIdx = len;
        int size = len;

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);

            switch(c) {
                case 'L':
                    if(!st1.isEmpty()) {
                        st2.push(st1.pop());    // st1 pop -> st2 push
                    }
                    break;
                case 'D':
                    if(!st2.isEmpty()) {
                        st1.push(st2.pop());    // st2 pop -> st1 push
                    }
                    break;
                case 'B':
                    if(!st1.isEmpty()) {
                        st1.pop();
                    }
                    break;
                case 'P':
                    char tmp = st.nextToken().charAt(0);
                    st1.push(tmp);
                    break;
                default:
                    break;
            }
        }

        while(!st1.isEmpty()) {
            st2.push(st1.pop());
        }

        while(!st2.isEmpty()) {
            sb.append(st2.pop());
        }

        bw.write(sb.toString());
        bw.flush();
    }
}