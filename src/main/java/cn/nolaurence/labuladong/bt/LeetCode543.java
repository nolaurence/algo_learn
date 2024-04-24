package cn.nolaurence.labuladong.bt;

public class LeetCode543 {

    /**
     * 由最大深度函数在后续位置增加了一个maxDiameter判断得来
     */
    int maxDiameter = 0;

    int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);

        maxDiameter = Math.max(maxDiameter, leftMax + rightMax);
        return 1 + Math.max(leftMax, rightMax);
    }
}
