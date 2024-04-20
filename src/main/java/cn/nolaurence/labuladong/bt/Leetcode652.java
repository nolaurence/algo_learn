package cn.nolaurence.labuladong.bt;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Leetcode652 {

    // 寻找重复的子树
    /**
     * point： 1. 前中后序遍历可以表达树的结构
     *         2. 后续遍历位置可以拿到root，left，right所有节点的值
     *         3. 通过hashmap记录重复的子树
     *         4. 通过list记录结果
     */

    // 记录所有子树以及出现的次数
    HashMap<String, Integer> memo = new HashMap<>();

    // 记录重复的子树根节点
    LinkedList<TreeNode> res = new LinkedList<>();

    // 主函数
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String left = traverse(root.left);
        String right = traverse(root.right);

        String subTree = left + "," + right + "," + root.val;

        int freq = memo.getOrDefault(subTree, 0);
        // 多次重复也只会被加入结果集一次
        if (freq == 1) {
            res.add(root);
        }
        // 给子树对于的出现次数加一
        memo.put(subTree, freq + 1);
        return subTree;
    }
}
