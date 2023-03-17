package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ10828 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        List<Integer> list = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();  // 명령

            switch (order) {
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    list.add(num);
                    break;
                case "pop":
                    if (list.size() == 0) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(list.get(list.size()-1)).append("\n");
                        list.remove(list.size() - 1);
                    }
                    break;
                case "size":
                    sb.append(list.size()).append("\n");
                    break;
                case "empty":
                    sb.append(list.size() == 0 ? 1 : 0).append("\n");
                    break;
                case "top":
                    sb.append(list.size() == 0 ? -1 : list.get(list.size()-1)).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
