package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = -1000001;
        int min = 1000001;

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine()," " );

        for(int i = 0; i<N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if(max < tmp)
                max = tmp;
            if(min > tmp)
                min = tmp;
        }

        System.out.println(min + " " + max);
    }
}
