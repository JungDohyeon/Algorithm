package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1969 {
    static int[][] charCounter;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");   // N, M 입력 받기

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        charCounter = new int[M][4];    // 알파벳 순 A, C, G, T
        int HammingDist = 0;    // Hamming Distance

        for(int i = 0; i<N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                char c = str.charAt(j);
                if (c == 'A') {
                    charCounter[j][0]++;
                } else if (c == 'C') {
                    charCounter[j][1]++;
                } else if (c == 'G') {
                    charCounter[j][2]++;
                } else {
                    charCounter[j][3]++;
                }
            }
        }


        for(int i = 0; i < M; i++) {
            int max = charCounter[i][0];
            int maxIdx = 0;
            for(int j = 1; j<4; j++) {
                if(charCounter[i][j] > max) {
                    max = charCounter[i][j];    // 가장 많이 나온 글자 개수
                    maxIdx = j;
                }
            }

            if(maxIdx == 0) {
                sb.append("A");
            } else  if(maxIdx == 1) {
                sb.append("C");
            } else  if(maxIdx == 2) {
                sb.append("G");
            } else {
                sb.append("T");
            }

            HammingDist += N - max; // Hamming Distance 처리
        }

        System.out.println(sb);
        System.out.println(HammingDist);
    }
}

