package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;


// 정규표현식 문제
public class BOJ9342 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        String regex = "^[A-F]?A+F+C+[A-F]?$";
        for(int test_case = 1; test_case <= T; test_case++) {
            String str = br.readLine();
            if(str.matches(regex))
                sb.append("Infected!\n");
            else
                sb.append("Good\n");
        }
        System.out.println(sb);
    }
}
