package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 회문
public class BOJ17609 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());    // test Case

        for (int test_case = 1; test_case <= T; test_case++) {
            String str = br.readLine(); // 한 개의 문자열 입력 받음
            int res = checkPalindrome(str, 0, str.length()-1, 0); // 회문 체크 값
            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }

    // 펠린드롬 수 체크
    static int checkPalindrome(String str, int left, int right, int round) {
        if(round == 2)
            return 2;

        int result = round;
        while(left < right) {
            // 유사 회문인 경우
            if(str.charAt(left) != str.charAt(right)) {
                result = Math.min(checkPalindrome(str, left+1, right, round+1), checkPalindrome(str, left, right-1, round+1));
                break;
            }
            left++;
            right--;
        }
        return result;
    }
}
