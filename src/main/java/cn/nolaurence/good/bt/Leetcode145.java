package cn.nolaurence.good.bt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode145 {
    // 动态规划思路
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> left = postorderTraversal(root.left);
        List<Integer> right = postorderTraversal(root.right);
        res.addAll(left);
        res.addAll(right);
        res.add(root.val);
        return res;
    }

    // 回溯算法
    LinkedList<Integer> res = new LinkedList<>();

    public List<Integer> postorderTraversal2(TreeNode root) {
        traverse(root);
        return res;
    }

    void traverse(TreeNode root) {

        if (root == null) {
            return;
        }
        traverse(root.left);
        traverse(root.right);
        res.add(root.val);
    }
}
