package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ10798 {
    static char[][] stringArr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        stringArr = new char[5][15];    // 5줄, 최대 15개 글자 저장 배열 생성

        // 5줄 입력 받기
        for (int i = 0; i<5; i++) {
            String line = br.readLine();    // 한 줄 입력
            int len = line.length();
            for(int j = 0; j < len; j++) {
                stringArr[i][j] = line.charAt(j);
            }
        }


        for(int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (stringArr[j][i] == '\0')
                    continue;
                bw.write(stringArr[j][i]);
            }
        }

        bw.flush();
        bw.close();
    }
}
