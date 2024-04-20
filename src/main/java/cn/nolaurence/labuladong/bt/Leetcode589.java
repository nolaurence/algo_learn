package cn.nolaurence.labuladong.bt;

import java.util.List;
import java.util.LinkedList;

public class Leetcode589 {

    public List<Integer> preorder(NTreeNode root) {
        traverse(root);
        return res;
    }

    List<Integer> res = new LinkedList<>();

    void traverse(NTreeNode root) {
        if (root == null) {
            return;
        }
        // 前序遍历位置
        res.add(root.val);
        for (NTreeNode child : root.children) {
            traverse(child);
        }
        // 后续遍历位置
    }
}

class Leetcode590 {
    public List<Integer> postorder(NTreeNode root) {
        traverse(root);

        return res;
    }

    List<Integer> res = new LinkedList<>();

    void traverse(NTreeNode root) {
        if (root == null) {
            return;
        }
        // 前序遍历位置
        for (NTreeNode child : root.children) {
            traverse(child);
        }
        // 后续遍历位置
        res.add(root.val);
    }
}
