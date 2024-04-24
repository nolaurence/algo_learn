package cn.nolaurence.labuladong.bt;

public class LeetCode104 {

    int depth = 0;
    int res = 0;

    public int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        depth++;
        res = Math.max(res, depth);
        traverse(root.left);
        traverse(root.right);
        depth--;
    }
}
