
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static class Node implements Comparable<Node> {
        int a;
        int b;

        public Node (int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Node o) {
            return this.a - o.a;
        }
    }

    static int N;
    static Node[] nodes;
    static ArrayList<Integer>list;
    static int[] idx;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        nodes = new Node[N];
        idx = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            nodes[i] = new Node(a, b);
        }

        Arrays.sort(nodes);
        list.add(0);

        binarySearch();
        sb.append(N - list.size() + 1).append("\n");

        int searchIndex = list.size() - 1;

        Stack<Integer> stack = new Stack<>();
        for (int i = N - 1; i > -1; i--) {
            if (idx[i] == searchIndex) {
                searchIndex--;
            } else {
                stack.push(nodes[i].a);
            }
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void binarySearch() {
        for (int i = 0; i < N; i++) {
            if (list.get(list.size() - 1) < nodes[i].b) {
                list.add(nodes[i].b);
                idx[i] = list.size() - 1;
            } else {
                int left = 1;
                int right = list.size() - 1;

                while(left < right) {
                    int mid = (left + right) >> 1;

                    if (list.get(mid) < nodes[i].b) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }

                list.set(right, nodes[i].b);
                idx[i] = right;
            }
        }
    }
}