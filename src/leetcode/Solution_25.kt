package leetcode

fun main() {
    val node = ListNode(1)
            .apply {
                next = ListNode(2).apply {
                    next = ListNode(3)
                            .apply {
                                next = ListNode(4).apply {
                                    next = ListNode(5)
                                }
                            }
                }
            }
    Solution_25().reverseKGroup(node, 3)?.print()
}

class Solution_25 {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        var start = ListNode()
        var curNode: ListNode? = head
        var beforeListNode: ListNode? = start //待反转链表的前一个节点
        while (curNode != null) {
            var times = k
            var reverseBegin = curNode //翻转前的子链表头节点，反转后变为尾节点
            var preNode:ListNode? = null
            while (times > 0 && curNode != null) {
                preNode = curNode
                curNode = curNode.next
                times--
            }
            if (times > 0) {
                //不足反转长度
                beforeListNode?.next = reverseBegin
                break
            } else {
                //进行翻转
                preNode?.next = null
                reverseLinkedList(reverseBegin, beforeListNode, curNode)
                beforeListNode = reverseBegin
            }
        }
        return start.next
    }

    fun reverseLinkedList(head: ListNode?, beforeNode: ListNode?, succeedNode: ListNode?) {
        var preNode: ListNode? = null
        var curNode = head
        while (curNode != null) {
            val next = curNode.next
            curNode.next = preNode
            preNode = curNode
            curNode = next
        }
        head?.next = succeedNode // 之前的头节点变为尾节点，连接下一个节点
        beforeNode?.next = preNode //现在的头节点，连到之前的节点
    }
}