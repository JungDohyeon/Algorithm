import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {

    private static class Node {
        int num;
        Node left, right;

        public Node(int num) {
            this.num = num;
        }

        public Node(int num, Node left, Node right) {
            this.num = num;
            this.left = left;
            this.right = right;
        }

        private void insert(int num) {
            if (num < this.num) {
                if (this.left == null)
                    this.left = new Node(num);
                else
                    this.left.insert(num);
            } else {
                if (this.right == null)
                    this.right = new Node(num);
                else
                    this.right.insert(num);
            }
        }
    }

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Node root = new Node(Integer.parseInt(br.readLine()));

        while(true) {
            String str = br.readLine();

            if(str == null || str.equals(""))
                break;

            root.insert(Integer.parseInt(str));
        }

        postOrder(root);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static private void postOrder(Node node) {
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.num).append("\n");
    }
}