package cn.nolaurence.labuladong.bt;

import java.util.LinkedList;
import java.util.List;

public class Leetcode94 {

    /**
     * 碎碎念
     * 二叉树的遍历代码是动态规划和回溯算法的祖宗
     * 动态规划思路的核心在于明确并利用函数的定义分解问题，中序遍历结果的特点是root.val在中间，左右子树在两侧
     */

    // 动态规划思路
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        res.addAll(inorderTraversal(root.left));
        res.add(root.val);
        res.addAll(inorderTraversal(root.right));
        return res;
    }

    // 回溯算法思路
    LinkedList<Integer> res = new LinkedList<>();

    public List<Integer> inorderTraversal2(TreeNode root) {
        traverse(root);
        return res;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        // 中序遍历位置
        res.add(root.val);
        traverse(root.right);
    }
}
