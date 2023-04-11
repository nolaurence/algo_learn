package cn.nolaurence.good.bt;

public class Leetcode559 {
    // 分解问题的思路
    public int disolve(NTreeNode root) {
        if (root == null) {
            return 0;
        }
        int subTreeMaxDepth = 0;
        for (NTreeNode child : root.children) {
            subTreeMaxDepth = Math.max(subTreeMaxDepth, disolve(child));
        }
        return subTreeMaxDepth + 1;
    }

    // 遍历的思路
    public int traverseMethod(NTreeNode root) {
        traverse(root);
        return res;
    }
    // 记录递归遍历到的深度
    int depth = 0;
    // 记录最大的深度
    int res = 0;

    void traverse(NTreeNode root) {
        if (root == null) {
            return;
        }
        // 前序遍历位置
        depth++;
        res = Math.max(res, depth);
        for (NTreeNode child : root.children) {
            traverse(child);
        }
        // 后续遍历位置
        depth--;
    }
}


class NTreeNode {
    int val;
    NTreeNode[] children;
}