package cn.nolaurence.good.linkedlist;

/**
 * @Author: nolaurence
 * @Description: leetcode 25
 * @Date: 2022/8/4
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        // 区间 [a, b) 包含 k 个待翻转元素
        ListNode a = head, b = head;
        for (int i = 0; i < k; i++) {
            // 不足 k 个，不需要翻转，base case
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        // 反转前 k 个元素
        ListNode newHead = reverse(a, b);
        // 递归反转后链表并连接起来
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    // 反转区间 [a, b) 的元素，注意是左闭右开
    ListNode reverse(ListNode a, ListNode b) {
        ListNode pre = null, cur = a, nxt = a;

        // while终止条件需要注意
        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        // 返回反转后的头节点
        return pre;
    }
}
