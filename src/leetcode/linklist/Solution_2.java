package leetcode.linklist;

/**
 * 2. 两数相加
 * 注意头节点，初始化一个-1节点指向头节点
 */

public class Solution_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode();
        ListNode l1Pointer = l1;
        ListNode l2Pointer = l2;
        int moreAdd = 0;
        ListNode nodeHead = node;
        while(l1Pointer != null || l2Pointer != null || moreAdd!=0) {
            ListNode temp = new ListNode(moreAdd);
            if (l1Pointer!=null) {
                temp.val+=l1Pointer.val;
                l1Pointer = l1Pointer.next;
            }
            if (l2Pointer!=null) {
                temp.val+=l2Pointer.val;
                l2Pointer = l2Pointer.next;
            }
            if (temp.val>9){
                moreAdd= 1;
                temp.val-=10;
            }else{
                moreAdd = 0;
            }
            node.next = temp;
            node = node.next;
        }
        return nodeHead.next;
    }
//
//    private ListNode addNext(ListNode curNode, ListNode l1Pointer, ListNode l2Pointer, boolean needAddOne) {
//        ListNode temp = new ListNode();
//        if (l1Pointer!=null) {
//            temp.val+= l1Pointer.val;
//            l1Pointer = l1Pointer.next;
//        }
//        if (l2Pointer!=null) {
//            temp.val+= l2Pointer.val;
//            l2Pointer = l2Pointer.next;
//        }
//        boolean needAdd = false;
//        if(temp.val>9) {
//            needAdd = true;
//            temp.val -= 10;
//        }
//        temp
//
//    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
