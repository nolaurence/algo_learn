package cn.nolaurence.labuladong.bt;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode107 {

    public List<List<Integer>> levelOrderBottoms(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        // while 循环控制从上向下一层层遍历
        while (!q.isEmpty()) {
            int size = q.size();
            // 记录这一层的节点值
            List<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                level.add(cur.val);
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            // 把每一层添加到头部，就是自底向上的层序遍历
            res.add(level);
        }
        return res;
    }
}
