
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr, idxArr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        idxArr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.add(Integer.MIN_VALUE);

        for (int i = 0; i < N; i++) {
            if (list.get(list.size() - 1) < arr[i]) {
                list.add(arr[i]);
                idxArr[i] = list.size() - 1;
            } else {
                int left = 1;
                int right = list.size() - 1;

                while(left < right) {
                    int mid = (left + right) >> 1;
                    if(list.get(mid) < arr[i]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }

                list.set(right, arr[i]);
                idxArr[i] = right;
            }
        }

        bw.write((list.size() - 1) + "\n");

        int idx = list.size() - 1;
        Stack<Integer> stack = new Stack<>();
        for(int i = N - 1; i >= 0; i--) {
            if (idxArr[i] == idx) {
                idx--;
                stack.push(arr[i]);
            }
        }

        while(!stack.isEmpty()) {
            bw.write(stack.pop() + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}