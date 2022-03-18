package leetcode.nodelist;

import java.util.HashMap;
import java.util.Map;

/**
 * 432. 全 O(1) 的数据结构
 * 实现 AllOne 类：
 * <p>
 * AllOne() 初始化数据结构的对象。
 * inc(String key) 字符串 key 的计数增加 1 。如果数据结构中尚不存在 key ，那么插入计数为 1 的 key 。
 * dec(String key) 字符串 key 的计数减少 1 。如果 key 的计数在减少后为 0 ，那么需要将这个 key 从数据结构中删除。测试用例保证：在减少计数前，key 存在于数据结构中。
 * getMaxKey() 返回任意一个计数最大的字符串。如果没有元素存在，返回一个空字符串 "" 。
 * getMinKey() 返回任意一个计数最小的字符串。如果没有元素存在，返回一个空字符串 "" 。
 * <p>
 * 理解：全O(1)的关键在与取最大/最小值，不要遍历直接拿到最大/最小值
 */
public class Solution_432 {

    public static void main(String[] args) {
        AllOne allOne = new AllOne();
        allOne.inc("a");
        allOne.inc("b");
        allOne.inc("b");
        allOne.inc("c");
        allOne.inc("c");
        allOne.inc("c");
        allOne.dec("b");
        allOne.dec("b");
        allOne.dec("a");
    }

    static class AllOne {

        private Map<String, Node> mMap;

        private Node head, tail;

        public AllOne() {
            mMap = new HashMap<>();
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.last = head;
        }

        public void inc(String key) {
            if (!mMap.containsKey(key)) {
                Node newNode = new Node(key);
                insertNewNode(newNode);
                mMap.put(key, newNode);
            } else {
                Node curNode = mMap.get(key);
                Node nextNode = curNode.next;
                while (nextNode != tail && nextNode.num == curNode.num) {
                    nextNode = nextNode.next; // 找到插入位置
                }
                curNode.num++; // 别忘记自增
                removeCurNode(curNode);
                insertNodeBeforeNext(curNode, nextNode);
            }
            System.out.println("inc" + key + " result:");
            printList();
        }

        private void printList() {
            Node node = head.next;
            while (node != tail) {
                System.out.print(node.value + node.num + "->");
                node = node.next;
            }
            System.out.println();
        }

        private void removeCurNode(Node node) {
            Node lastNode = node.last;
            Node nextNode = node.next;
            lastNode.next = nextNode;
            nextNode.last = lastNode;
        }

        private void insertNodeBeforeNext(Node insertNode, Node nextNode) {
            Node lastNode = nextNode.last;
            lastNode.next = insertNode;
            insertNode.last = lastNode;
            insertNode.next = nextNode;
            nextNode.last = insertNode;
        }

        private void insertNewNode(Node node) {
            Node tmp = head.next;
            head.next = node;
            node.next = tmp;
            node.last = head;
            tmp.last = node;
        }

        public void dec(String key) {
            Node curNode = mMap.get(key);
            Node lastNode = curNode.last;
            while (lastNode != head && lastNode.num == curNode.num) {
                lastNode = lastNode.last;// 找到插入位置
            }
            curNode.num--;//别忘记自减
            removeCurNode(curNode);
            if(curNode.num != 0) {
                // num不为0才重新加入
                insertNodeAfterLast(curNode, lastNode);
            }
            System.out.println("dec" + key + " result:");
            printList();
        }

        private void removeNode (){

        }

        private void insertNodeAfterLast(Node insertNode, Node lastNode) {
            Node nextNode = lastNode.next;
            nextNode.last = insertNode;
            insertNode.next = nextNode;
            insertNode.last = lastNode;
            lastNode.next = insertNode;
        }

        public String getMaxKey() {
            return tail.last.value;
        }

        public String getMinKey() {
            return head.next.value;
        }
    }

    static class Node {
        public Node() {
            value = ""; // 默认空字符串
            num = 1;
        }

        public Node(String val) {
            value = val;
            num = 1;
        }

        public Node last;
        public Node next;
        public String value;
        public int num;
    }

}
