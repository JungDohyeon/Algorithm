
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        char value;
        Node left;
        Node right;

        public Node(char value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    static int N;
    static Node[] tree;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        tree = new Node[N];
        tree[1] = new Node('A', null, null);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if (tree[parent - 'A'] == null) {
                tree[parent - 'A'] = new Node(parent, null, null);
            }

            if (left != '.') {
                tree[left - 'A'] = new Node(left, null, null);
                tree[parent - 'A'].left = tree[left - 'A'];
            }

            if (right != '.') {
                tree[right - 'A'] = new Node(right, null, null);
                tree[parent - 'A'].right = tree[right - 'A'];
            }
        }

        preOrder(tree[0]);
        sb.append("\n");
        inOrder(tree[0]);
        sb.append("\n");
        postOrder(tree[0]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void preOrder(Node n) {
        if (n == null)
            return;

        sb.append(n.value);
        preOrder(n.left);
        preOrder(n.right);
    }

    private static void inOrder(Node n) {
        if (n == null)
            return;

        inOrder(n.left);
        sb.append(n.value);
        inOrder(n.right);
    }

    private static void postOrder(Node n) {
        if (n == null)
            return;

        postOrder(n.left);
        postOrder(n.right);
        sb.append(n.value);
    }
}
