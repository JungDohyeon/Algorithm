
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<Integer, String> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N; i++) {
            String S = br.readLine();
            map1.put(i, S);
            map2.put(S, i);
        }

        for(int i = 0; i < M; i++) {
            String str = br.readLine();

            if(49 <= str.charAt(0) && str.charAt(0) <= 57) {
                bw.write(map1.get(Integer.parseInt(str)) + "\n");
            }else {
                bw.write(map2.get(str) + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}