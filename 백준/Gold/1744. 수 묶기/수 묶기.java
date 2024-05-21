import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
    static LinkedList<Integer> positive;
    static LinkedList<Integer> negative;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 양수 음수 따로 저장
        positive = new LinkedList<>();
        negative = new LinkedList<>();

        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 0) {
                positive.add(num);
            } else {
                negative.add(num);
            }
        }

        positive.sort(Collections.reverseOrder());
        Collections.sort(negative);

        int sum = 0;
        int pIdx = 0;
        while(pIdx < positive.size()) {
            if (pIdx + 1 < positive.size() && positive.get(pIdx+1) != 1 && positive.get(pIdx) != 1) {
                sum += positive.get(pIdx++) * positive.get(pIdx++);
            } else {
                sum += positive.get(pIdx++);
            }
        }

        int nIdx = 0;
        while(nIdx < negative.size()) {
            if (nIdx + 1 < negative.size() && negative.get(nIdx+1) != 1 && negative.get(nIdx) != 1) {
                sum += negative.get(nIdx++) * negative.get(nIdx++);
            } else {
                sum += negative.get(nIdx++);
            }
        }

        System.out.println(sum);

    }
}
