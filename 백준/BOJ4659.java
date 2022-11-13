package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ4659 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // end 나오기 전까지 반복
        while (true) {
            String test = br.readLine();

            // 'end'가 들어온 경우 종료
            if (test.equals("end"))
                break;

            // 조건에 맞게 출력 형식 지정
            sb.append(validCheck(test) ? "<" + test + "> is acceptable. \n" : "<" + test + "> is not acceptable.\n");
        }
        System.out.println(sb);
    }

    // 모음 체크
    static boolean isVowel(char c) {
        // 모음을 갖고 있는 경우
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            return true;
        return false;
    }

    // Validation Check
    static boolean validCheck(String str) {
        int countVowels = 0;    // 모음 개수
        int continuousV = 0;    // 연속으로 배치된 모음
        int continuousC = 0;    // 연속으로 배치된 자음

        for (int i = 0; i < str.length(); i++) {
            // 모음인 경우
            if (isVowel(str.charAt(i))) {
                countVowels++;
                continuousC = 0; // 모음이 나왔으므로 연속 자음은 0으로 초기화
                continuousV++;

                // 연속된 모음 개수가 3개라면 false
                if(continuousV == 3)
                    return false;
            }
            // 자음인 경우
            else {
                continuousV = 0;
                continuousC++;

                // 연속된 자음 개수가 3개라면 false
                if(continuousC == 3)
                    return false;
            }

            // 3번 조건
            if(i > 0) {
                if((str.charAt(i) == str.charAt(i-1)) && (str.charAt(i) != 'e' && str.charAt(i) != 'o'))
                    return false;
            }
        }

        // 1번조건 불 만족 (모음 개수 == 0)
        if(countVowels == 0)
            return false;

        return true;
    }
}
