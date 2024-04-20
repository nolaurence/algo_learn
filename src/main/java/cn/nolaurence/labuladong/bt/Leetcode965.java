package cn.nolaurence.labuladong.bt;

public class Leetcode965 {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        prev = root.val;
        traverse(root);
        return isUnival;
    }

    int prev;
    boolean isUnival = true;

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.val != prev) {
            isUnival = false;
            return;
        }
        traverse(root.left);
        traverse(root.right);
    }
}
