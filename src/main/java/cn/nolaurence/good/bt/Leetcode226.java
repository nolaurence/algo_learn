package cn.nolaurence.good.bt;

public class Leetcode226 {

    public TreeNode inverseTree(TreeNode root) {
        traverse(root);
        return root;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        // 前序位置
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // 遍历框架
        traverse(root.left);
        traverse(root.right);
    }

    TreeNode inverseTreeMethod2(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = inverseTreeMethod2(root.left);
        TreeNode right = inverseTreeMethod2(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
     this.val = val;
     this.left = left;
     this.right = right;
    }
}
