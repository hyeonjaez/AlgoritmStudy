import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            Node[] tree = new Node[N + 1];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                char parentNode = st.nextToken().charAt(0);
                char leftNode = st.nextToken().charAt(0);
                char rightNode = st.nextToken().charAt(0);

                if (tree[parentNode - 'A'] == null) {
                    tree[parentNode - 'A'] = new Node(parentNode);
                }

                if (leftNode != '.') {
                    tree[leftNode - 'A'] = new Node(leftNode);
                    tree[parentNode - 'A'].left = tree[leftNode - 'A'];
                }

                if (rightNode != '.') {
                    tree[rightNode - 'A'] = new Node(rightNode);
                    tree[parentNode - 'A'].right = tree[rightNode - 'A'];
                }
            }

            preorder(tree[0]);
            System.out.println();

            inorder(tree[0]);
            System.out.println();

            postorder(tree[0]);
            System.out.println();

        }
    }

    public static void preorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    // 중위 순회
    public static void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.value);
        inorder(node.right);
    }

    // 후위 순회
    public static void postorder(Node node) {
        if (node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value);
    }
}

class Node {
    char value;
    Node left;
    Node right;

    public Node(char value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}