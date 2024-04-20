package cn.nolaurence.labuladong.linkedlist;

/**
 * @Author: nolaurence
 * @Description: HasCycle
 * @Date: 2022/8/1
 */
public class HasCycle {
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
}
