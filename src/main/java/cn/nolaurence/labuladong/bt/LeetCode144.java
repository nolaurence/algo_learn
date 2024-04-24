package cn.nolaurence.labuladong.bt;

import java.util.LinkedList;
import java.util.List;

public class LeetCode144 {

    LinkedList<Integer> res = new LinkedList<>();

    List<Integer> preorderTraversal(TreeNode root) {
        traverse(root);
        return res;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        res.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }

}
