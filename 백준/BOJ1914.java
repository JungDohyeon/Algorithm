package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ1914 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        BigInteger cnt = new BigInteger("2");   // n이 100인 경우 long 범위 벗어남
        cnt = cnt.pow(n).subtract(new BigInteger("1"));

        System.out.println(cnt);
        if(n <= 20) {
            move(n, 1,2, 3);
            System.out.println(sb);
        }
    }

    static void move (int circle, int start, int mid, int dest) {
        // 원판이 하나 있는 경우 1 -> 3 으로 바로 이동하면 끝
        if(circle == 1) {
            sb.append(start +  " " + dest + "\n");
            return;
        }

        // n-1개 원판을 중간지점으로 이동시킨다. (1 -> 2)
        move(circle - 1, start, dest, mid);

        // 맨 앞 1번칸에 있는 원판을 맨 마지막으로 이동 (1 -> 3)
        sb.append(start + " " + dest + "\n");

        // 중간에 있는 n-1개의 원판을 맨 마지막 칸으로 이동시킨다. (2 -> 3)
        move(circle - 1, mid, start, dest);
    }
}
