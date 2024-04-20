package cn.nolaurence.labuladong.bt;

import java.util.ArrayList;

public class Leetcode501 {
    ArrayList<Integer> mode = new ArrayList<>();
    TreeNode prev = null;
    // 当前元素的重复次数
    int curCount = 0;
    // 全局的最长相同序列长度
    int maxCount = 0;

    public int[] findMode(TreeNode root) {
        // 执行中序遍历
        traverse(root);

        int[] res = new int[mode.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = mode.get(i);
        }
        return res;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);

        // 中序遍历位置
        if (prev == null) {
            // 初始化
            curCount = 1;
            maxCount = 1;
            mode.add(root.val);
        } else {
            if (root.val == prev.val) {
                // root.val重复的情况
                curCount++;
                if (curCount == maxCount) {
                    // root.val 是众数
                    mode.add(root.val);
                } else if (curCount > maxCount) {
                    // 更新众数
                    mode.clear();
                    mode.add(root.val);
                    maxCount = curCount;
                }
            }

            if (root.val != prev.val) {
                // root.val不重复的情况
                curCount = 1;
                if (curCount == maxCount) {
                    // root.val 是众数
                    mode.add(root.val);
                }
            }
        }
        // 更新prev
        prev = root;
        traverse(root.right);
    }
}
