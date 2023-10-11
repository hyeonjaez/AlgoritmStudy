import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    Node root;

    public void insert(int value) {
        this.root = insert(this.root, value);
    }

    public Node insert(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (root.value > value) {
            root.left = insert(root.left, value);
        } else if (root.value < value) {
            root.right = insert(root.right, value);
        }

        return root;
    }

    public void print(){
        postfixOrder(this.root);
    }

    public void postfixOrder(Node root) {
        if (root != null) {
            postfixOrder(root.left);
            postfixOrder(root.right);
            System.out.println(root.value);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main main = new Main();
        String input;
        while (true) {
            input = br.readLine();
            if (input == null || input.equals("")) {
                break;
            }
            main.insert(Integer.parseInt(input));
        }

        main.print();
    }


}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
}