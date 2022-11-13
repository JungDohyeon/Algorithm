package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1874 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] stack = new int[N];
        int top = -1;
        int inputStart = 1;     // 스택에 들어갈 처음 수 저장 (맨 처음엔 1부터 삽입)

        for(int i = 0; i < N; i++) {
            int output = Integer.parseInt(br.readLine());    // 입력 받는 수

            // 스택에 들어가야하는 값보다 큰 경우 그 값까지 input
            if (output >= inputStart) {
                while(inputStart <= output) {
                    stack[++top] = inputStart++;
                    sb.append("+").append("\n");
                }
            }

            else {
                // 스택에서 뽑을 때 나와야 하는 결과 값과 다른 경우
                if(stack[top] != output) {
                    System.out.println("NO");
                    System.exit(0);
                }
            }

            // 데이터 추출
            top--;
            sb.append("-").append("\n");
        }
        System.out.println(sb);
    }
}
