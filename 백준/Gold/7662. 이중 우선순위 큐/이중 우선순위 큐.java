import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static int T, k;
    static TreeMap<Integer, Integer> map;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            k = Integer.parseInt(br.readLine());
            map = new TreeMap<>();

            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                char op = st.nextToken().charAt(0);
                int n = Integer.parseInt(st.nextToken());

                if (op == 'I') {
                    map.put(n, map.getOrDefault(n, 0) + 1);
                } else {
                    if (map.size() == 0)
                        continue;

                    int num = (n == 1) ? map.lastKey() : map.firstKey();
                    if (map.put(num, map.get(num) - 1) == 1)
                        map.remove(num);
                }
            }

            sb.append(map.size() == 0 ? "EMPTY" : map.lastKey() + " " + map.firstKey()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
