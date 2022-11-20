package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ4949 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            Stack<Character> st = new Stack<>();

            String str = br.readLine();
            if(str.length() == 1 && str.charAt(0) == '.')
                break;

            boolean flag = true;

            for(int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if(c == '(' || c == '[')
                    st.push(c);

                else if (c == ')') {
                    if(st.isEmpty() || st.peek() != '(') {
                        flag = false;
                        break;
                    } else {
                        st.pop();
                    }
                }

                else if (c == ']') {
                    if (st.isEmpty() || st.peek() != '[') {
                        flag = false;
                        break;
                    } else {
                        st.pop();
                    }
                }
            }

            if(st.isEmpty() && flag)
                sb.append("yes").append("\n");
            else
                sb.append("no").append("\n");
        }
        System.out.println(sb);
    }
}
