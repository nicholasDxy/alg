package leetcode

import java.util.Deque
import java.util.Stack

fun main() {
    val node1 = ListNode(1).apply {
        next = ListNode(4).apply {
            next = ListNode(5)
        }
    }
    val node2 = ListNode(1).apply {
        next = ListNode(3).apply {
            next = ListNode(4)
        }
    }
    val node3 = ListNode(2).apply {
        next = ListNode(6)
    }
    Solution_23().mergeKLists(arrayOf<ListNode>(node1, node2, node3))?.print()
}

class Solution_23 {
    fun mergeKLists(lists: Array<ListNode>): ListNode? {
        val nodeStack = ArrayDeque<ListNode>()
        for (listNode in lists) {
            listNode?.apply {
                nodeStack.add(this)
            }
        }
        while (nodeStack.size > 1) {
            val nodeList1 = nodeStack.removeFirst()
            val nodeList2 = nodeStack.removeFirst()
            nodeStack.addLast(merge2List(nodeList1, nodeList2))
        }
        return if (nodeStack.isEmpty()) {
            null
        } else {
            nodeStack.removeFirst()
        }
    }

    private fun merge2List(list1: ListNode, list2: ListNode): ListNode {
        var curNode1: ListNode? = list1
        var curNode2: ListNode? = list2
        val start = ListNode()
        var curResultNode = start
        while (curNode1 != null || curNode2 != null) {
            if (curNode1 == null) {
                curResultNode.next = curNode2
                break
            }
            if (curNode2 == null) {
                curResultNode.next = curNode1
                break
            }
            if (curNode1.`val` > curNode2.`val`) {
                curResultNode.next = curNode2
                curNode2 = curNode2.next
            } else {
                curResultNode.next = curNode1
                curNode1 = curNode1.next
            }
            curResultNode = curResultNode.next
        }
        return start.next
    }
}