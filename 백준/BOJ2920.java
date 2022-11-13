package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2920 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[8];

        for(int i = 0; i < 8; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int asc = 0;
        int des = 0;

        for(int i = 0; i < 4; i++) {
            if (num[i] == i + 1 && (num[i] + num[7-i] == 9)) {
                asc++;
            }

            if (num[i] == 8-i && (num[i] + num[7-i] == 9)) {
                des++;
            }
        }

        if(asc == 4) {
            System.out.println("ascending");
        } else if (des == 4) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }
}
