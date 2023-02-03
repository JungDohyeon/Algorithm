package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ11729 {
    public static int cnt;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        cnt = 0;

        int n = Integer.parseInt(br.readLine());

        move(n, 1, 2,3);
        System.out.println(cnt);
        System.out.println(sb);
    }

    static void move (int circle, int start, int mid, int dest) {
        cnt++;

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
