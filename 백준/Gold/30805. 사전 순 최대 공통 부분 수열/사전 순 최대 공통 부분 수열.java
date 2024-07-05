
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static class Element implements Comparable<Element> {
        int value;
        int index;

        public Element(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Element o) {
            if (o.value == this.value)
                return this.index - o.index;
            else
                return o.value - this.value;
        }
    }

    static int N, M;
    static Element[] A, B;
    static int[] ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        A = new Element[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = new Element(Integer.parseInt(st.nextToken()), i);
        }

        M = Integer.parseInt(br.readLine());
        B = new Element[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = new Element(Integer.parseInt(st.nextToken()), i);
        }

        if (N > M) {
            ans = new int[N];
        } else {
            ans = new int[M];
        }

        Arrays.sort(A);
        Arrays.sort(B);

        int indexA = 0;
        int indexB = 0;

        int curIdxA = -1;
        int curIdxB = -1;
        int cnt = 0;

        while (indexA < N && indexB < M) {
            if (A[indexA].value > B[indexB].value) {
                indexA++;
            } else if (A[indexA].value < B[indexB].value) {
                indexB++;
            } else {
                if (A[indexA].index > curIdxA && B[indexB].index > curIdxB) {
                    curIdxA = A[indexA].index;
                    curIdxB = B[indexB].index;
                    ans[cnt++] = A[indexA].value;

                    indexA++;
                    indexB++;
                } else if (B[indexB].index <= curIdxB) {
                    indexB++;
                } else if (A[indexA].index <= curIdxA) {
                    indexA++;
                }
            }
        }

        sb.append(cnt).append("\n");

        for (int i = 0; i < cnt; i++) {
            sb.append(ans[i]).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
