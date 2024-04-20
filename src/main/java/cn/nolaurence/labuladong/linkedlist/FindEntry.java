package cn.nolaurence.labuladong.linkedlist;

/**
 * @Author: nolaurence
 * @Description: FindEntry
 * @Date: 2022/8/1
 */
public class FindEntry {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
