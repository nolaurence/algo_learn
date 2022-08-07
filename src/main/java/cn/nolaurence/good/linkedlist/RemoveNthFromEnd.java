package cn.nolaurence.good.linkedlist;

/**
 * @Author: nolaurence
 * @Description: RemoveNthFromEnd
 * @Date: 2022/8/2
 */
public class RemoveNthFromEnd {
    // 主函数
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 虚拟头结点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
        ListNode x = findFromEnd(dummy, n + 1);

        // 删掉倒数第n个节点
        x.next = x.next.next;
        return dummy.next;
    }

    // 返回链表的导数第 k 个节点
    ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;

        // p1 先走 k 步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        // p1 and p2 同时走 n - k 步
        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        // p2 现在指向第 n - k 个节点
        return p2;
    }
}
