package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1092 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Integer> crane = new ArrayList<>();
        List<Integer> box = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            crane.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }

        crane.sort(Collections.reverseOrder());
        box.sort(Collections.reverseOrder());

        int res = 0;

        if(crane.get(0) < box.get(0)) {
            System.out.println(-1);
        } else {
            // 박스를 다 옮길 때 까지 (Greedy)
            while(!box.isEmpty()) {
                int idx = 0;
                for (int i = 0; i < N; ) {
                    // 옮길 박스가 없다면 break;
                    if (idx == box.size())
                        break;
                    else if (crane.get(i) >= box.get(idx)) {
                        box.remove(idx);
                        i++;
                    } else
                        idx++;
                }
                res++;
            }
            System.out.println(res);
        }
    }
}
