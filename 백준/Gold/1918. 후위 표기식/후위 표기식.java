import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String description = br.readLine();

        Stack<Character> st = new Stack<>();
        for(int i = 0; i < description.length(); i++) {
           char c = description.charAt(i);

           if ('A' <= c && c <= 'Z') {
               sb.append(c);
           } else if (c == '(') {
               st.push(c);
           } else if (c == ')') {
               while(!st.isEmpty()) {
                   if (st.peek() == '(') {
                       st.pop();
                       break;
                   }

                   sb.append(st.pop());
               }
           } else {
               while(!st.isEmpty() && opPrior(st.peek()) >= opPrior(c)) {
                    sb.append(st.pop());
               }

               st.push(c);
           }
        }

        while(!st.isEmpty()) {
            sb.append(st.pop());
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int opPrior(char op) {
        switch (op) {
            case '(':
                return 0;
            case '+' :
            case '-':
                return 1;
            default:
                return 2;
        }
    }
}
