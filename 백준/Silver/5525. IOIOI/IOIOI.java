
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        String str = br.readLine();

        int len = 0;
        int cnt = 0;

        for (int i = 1; i < M - 1; i++) {
            if(str.charAt(i-1) == 'I' && str.charAt(i) == 'O' && str.charAt(i+1) == 'I') {
                len++;

                if(len == N) {
                    cnt++;
                    len--;
                }

                i++;
            } else {
                len = 0;
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }
}