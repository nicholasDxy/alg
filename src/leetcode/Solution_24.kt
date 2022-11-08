package leetcode

import leetcode.ListNode

fun main() {
    Solution_24().swapPairs(ListNode(1)
            .apply {
                next = ListNode(2).apply {
                    next = ListNode(3)
                            .apply { next = ListNode(4) }
                }
            }
    )?.print()
    Solution_24().swapPairs(ListNode(1))?.print()
    Solution_24().swapPairs(null)?.print()
}

class Solution_24 {
    fun swapPairs(head: ListNode?): ListNode? {
        val start = ListNode()
        var curResultNode = start
        var curNode = head
        while (curNode != null) {
            if (curNode.next == null) {
                curResultNode.next = curNode
                break
            }
            val nextNode = curNode.next
            val nextNextNode = nextNode.next
            curResultNode.next = nextNode
            nextNode.next = curNode
            curResultNode = curNode
            curResultNode.next = null
            curNode = nextNextNode
        }
        return start.next
    }

}