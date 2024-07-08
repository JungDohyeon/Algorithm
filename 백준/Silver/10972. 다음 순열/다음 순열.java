
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] numArr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        if (!solution(numArr)) {
            sb.append("-1");
        } else {
            for(int k: numArr) {
                sb.append(k).append(" ");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static boolean solution(int[] numArr) {
        int i = numArr.length - 1;

        while (i > 0 && numArr[i - 1] >= numArr[i]) {
            i -= 1;
        }

        if (i <= 0)
            return false;

        int j = numArr.length - 1;
        while (numArr[i - 1] >= numArr[j]) {
            j -= 1;
        }

        int temp = numArr[j];
        numArr[j] = numArr[i - 1];
        numArr[i - 1] = temp;

        j = numArr.length - 1;

        while (i < j) {
            temp = numArr[i];
            numArr[i] = numArr[j];
            numArr[j] = temp;
            i += 1;
            j -= 1;
        }

        return true;
    }
}

