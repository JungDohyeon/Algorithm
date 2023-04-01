package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ9093 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                String tmp = st.nextToken();
                char[] arr = tmp.toCharArray();

                int len = tmp.length();
                int halfLen = tmp.length() >> 1;     // 단어의 길이

                for(int j = 0; j < halfLen; j++) {
                    char c = arr[j];
                    arr[j] = arr[len-1-j];
                    arr[len-1-j] = c;
                }
                sb.append(new String(arr)).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
