package Programmers;

public class JadenCase {
    public static void main(String[] args) {

    }

    public String solution(String s) {
        boolean checkFirstChar = true;
        StringBuilder sb = new StringBuilder();

        int len = s.length();
        for(int i = 0; i < len; i++) {
            char tmp = s.charAt(i);

            if(checkFirstChar) {
                sb.append(Character.toUpperCase(tmp));
                checkFirstChar = false;
            } else {
                sb.append((Character.toLowerCase(tmp)));
            }

            if(tmp ==  ' ') {
                checkFirstChar = true;
            }
        }
        return sb.toString();
    }
}
