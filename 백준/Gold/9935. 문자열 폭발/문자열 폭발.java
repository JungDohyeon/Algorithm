
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

        String str = br.readLine();
        String bomb = br.readLine();

        int strLen = str.length();
        int bombLen = bomb.length();

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < strLen; i++) {
            st.push(str.charAt(i));

            if (st.size() >= bombLen) {
                boolean flag = true;

                for (int j = 0; j < bombLen; j++) {
                    if(st.get(st.size() - bombLen + j) != bomb.charAt(j)) {
                        flag = false;
                        break;
                    }
                }

                if(flag) {
                    for (int j = 0; j < bombLen; j++)
                        st.pop();
                }
            }
        }

        if(st.isEmpty()) {
            sb.append("FRULA");
        } else {
            for(Character c: st)
                sb.append(c);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
