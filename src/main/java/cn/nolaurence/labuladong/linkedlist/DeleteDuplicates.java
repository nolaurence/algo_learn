package cn.nolaurence.labuladong.linkedlist;

/**
 * @Author: nolaurence
 * @Description: DeleteDuplicates
 * @Date: 2022/8/7
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head, fast = head;
        while (fast != null) {
            if (fast.val != slow.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }

        slow.next = null;
        return head;
    }
}
