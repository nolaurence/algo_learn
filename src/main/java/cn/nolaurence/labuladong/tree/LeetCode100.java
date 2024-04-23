package cn.nolaurence.labuladong.tree;

public class LeetCode100 {

    /**
     * 给你两棵二叉树的根节点p和q，编写一个函数来检验这两棵树是否相同。如果两个树
     * 再结构上相同，并且节点具有相同的值，则认为他们是相同的
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
