package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ10799 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String bar = br.readLine();
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < bar.length(); i++) {
            st.push(bar.charAt(i));
        }

        int existBar = 0;
        int ans = 0;

        // stack이 빌 때 까지
        while(!st.isEmpty()) {
            char tmp = st.pop();

            if(tmp == ')') {
                existBar++; // 쇠 파이프 추가
                if (st.peek() == '(') { // 레이저 광선
                    existBar--; // 위에서 더한 파이프 제거 -> 레이저 광선이기 때문
                    st.pop();
                    ans += existBar;    // 현재 존재하는 바 만큼 더해주기
                }
            } else {
                ans++; // 파이프 길이가 끝난 경우 잘린 나머지 부분 더해주기
                existBar--; // 토막 더한 후 개수 줄여주기
            }
        }

        System.out.println(ans);
    }
}
