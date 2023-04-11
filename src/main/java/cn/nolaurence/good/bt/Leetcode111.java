package cn.nolaurence.good.bt;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode111 {
    /**
     * 二叉树的最小深度
     * 最小深度：从根节点到最近叶子结点的最短路径上的节点数量
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 1;

        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                // 判断是否到达叶子结点
                if (cur.left == null && cur.right == null) {
                    return depth;
                }
                // 将下一层结点加入队列
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
                depth++;
            }
        }
        return depth;
    }
}
