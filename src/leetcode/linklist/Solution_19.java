package leetcode.linklist;

import leetcode.ListNode;

import java.lang.reflect.Proxy;

/**
 * 删除节点
 */
public class Solution_19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;
        for (int i = n; i > 1; i--) {
            fast = fast.next;
        }
        ListNode preSlow = null; // 记录slow节点前一个
        while(fast.next!=null) {
            fast = fast.next;
            preSlow = slow;
            slow = slow.next;
        }
        if (preSlow == null) {
            // 删除头节点
            return slow.next;
        } else {
            preSlow.next = slow.next;
            return head;
        }
    }
}
