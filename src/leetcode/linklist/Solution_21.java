package leetcode.linklist;

import leetcode.ListNode;

/**
 * 21. 合并两个有序链表
 */
public class Solution_21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode l1CurNode = list1;
        ListNode l2CurNode = list2;
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode newHead;
        if (list1.val > list2.val) {
            newHead = l2CurNode;
            l2CurNode = l2CurNode.next;
        } else {
            newHead = l1CurNode;
            l1CurNode = l1CurNode.next;
        }
        ListNode curNew = newHead;
        while (l1CurNode != null || l2CurNode != null) {
            boolean useL1Node;
            if (l1CurNode == null) {
                useL1Node = false;
            } else if (l2CurNode == null) {
                useL1Node = true;
            } else {
                useL1Node = l1CurNode.val < l2CurNode.val;
            }
            if (useL1Node) {
                curNew.next = l1CurNode;
                l1CurNode = l1CurNode.next;
            } else {
                curNew.next = l2CurNode;
                l2CurNode = l2CurNode.next;
            }
            curNew = curNew.next;
        }
        return newHead;
    }
}
