package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ16637 {
    static String str;
    static int n;
    static int max_val;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        str = br.readLine();
        max_val = Integer.MIN_VALUE;

        dfs(0,0);
        System.out.println(max_val);
    }

    public static int cal(int a, char op, int b) {
        int res = a;
        switch (op) {
            case '+':
                res += b;
                break;
            case  '-':
                res -= b;
                break;
            case '*':
                res *= b;
                break;
        }
        return res;
    }

    public static void dfs(int idx, int cur) {
        // 최댓값 갱신
        if(idx > n -1) {
            max_val = Math.max(max_val, cur);
            return;
        }

        // 처음이면 더하기
        char operator = (idx==0) ? '+' : str.charAt(idx - 1);

        // 괄호 묶기
        if(idx + 2 < n) {
            int tmp = cal(str.charAt(idx) - '0', str.charAt(idx+1), str.charAt(idx+2) - '0');
            dfs(idx + 4, cal(cur, operator, tmp));
        }

        // 괄호 X
        dfs(idx+2, cal(cur, operator, str.charAt(idx) - '0'));
    }
}
