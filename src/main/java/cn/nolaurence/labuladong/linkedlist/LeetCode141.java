package cn.nolaurence.labuladong.linkedlist;

import org.junit.jupiter.api.Test;

/**
 * @Author: nolaurence
 * @Description: HasCycle
 * @Date: 2022/8/1
 */
public class LeetCode141 {
    public boolean hasCycle(ListNode head) {
        // 快慢指针初始化指向head
        ListNode slow = head, fast = head;

        // 快指针走到末尾时停止
        while (fast != null && fast.next != null) {
            // 慢指针走一步，快指针走两步
            slow = slow.next;
            fast = fast.next.next;
            // 快慢指针相遇，说明有环
            if (slow == fast) {
                return true;
            }
        }
        // 没有相遇则不包含欢
        return false;
    }

    @Test
    public void test() {
        ListNode tail = new ListNode(-4);
        ListNode head = new ListNode(0);
        head.next = tail;
        ListNode temp = new ListNode(2);
        temp.next = head;
        head = temp;
        tail.next = head;
        temp = new ListNode(3);
        temp.next = head;
        head = temp;

        System.out.println(hasCycle(head));
    }
}
