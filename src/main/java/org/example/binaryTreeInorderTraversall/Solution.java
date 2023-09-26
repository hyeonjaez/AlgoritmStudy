package org.example.binaryTreeInorderTraversall;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {

    }

    private static List<Integer> answer = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        solution(root);
        return answer;
    }

    public void solution(TreeNode root) {

        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        answer.add(root.val);
        inorderTraversal(root.right);
    }

    public void solutionStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pr = root;
        while (root != null && !stack.empty()) {
            while (root != null) {
                stack.push(root);
                pr = pr.left;
            }
            pr = stack.pop();
            answer.add(pr.val);
            pr = pr.right;

        }
    }


}
