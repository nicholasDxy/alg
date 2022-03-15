package leetcode.binarysearch;

import java.util.*;

/**
 * 145. 二叉树的后序遍历
 */
public class Solution_145 {

    private List<Integer> mIntegerList = new ArrayList<Integer>();

    public List<Integer> postorderTraversal(TreeNode root) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node0 = new TreeNode(0, node1, node2);
        return new Solution_145().postOrderTraverseIterate_1(node0);
    }

    private void postOrderTraverseRecursion(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraverseRecursion(root.left);
        postOrderTraverseRecursion(root.right);
        mIntegerList.add(root.val);
    }

    /**
     * *************************************** 后序遍历迭代1-利用前序遍历方式反转
     */
    /**
     * 后序遍历迭代1-利用前序遍历方式反转
     */
    private List<Integer> postOrderTraverseIterate(TreeNode root) {
        List<Integer> intList = new ArrayList<Integer>();
        Stack<TreeNode> nodeStack = new Stack<>();
        if (root == null) {
            return intList;
        }
        nodeStack.push(root);
        while (!nodeStack.empty()) {
            TreeNode node = nodeStack.pop();
            intList.add(node.val);
            if (node.left != null) nodeStack.push(node.left);
            if (node.right != null) nodeStack.push(node.right);
        }
        return reverse(intList);
    }

    private List<Integer> reverse(List<Integer> intList) {
        List<Integer> reverseList = new ArrayList<>();
        for (int index = intList.toArray().length - 1; index >= 0; index--) {
            reverseList.add(intList.get(index));
        }
        return reverseList;
    }

    /**
     * *************************************** 正规迭代解法
     */
    /**
     * 后序遍历
     * 父节点在栈内会被访问两次，第一次从左子树出栈后访问父节点时，父节点不进行出栈，而是将右子树入栈，继续访问右子树。
     * 只有当右子树出栈后访问父节点时，父节点才会出栈。
     * 所以要记录上一个出栈的节点，用来判断一个节点的右子树是否被访问过。
     * 迭代流程：
     * 【1】找到最左下方节点并将路径上的节点入栈直到node.left为空
     * 【2】判断栈顶(最左下方节点)node.right是否为空，不为空则以node.right为起始节点继续【1】的操作
     * 【3】如果没有右节点/右节点已被访问过，则弹出栈顶元素,并记录当前弹出的节点(用来判断是否是从右子树遍历到父节点)
     */
    private List<Integer> postOrderIterate(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curNode = root; // 标志当前节点（当节点进行入栈时不为空，节点为空时标志该出栈）
        TreeNode lastPopNode = null;// 记录上一个出栈的node
        while (!stack.isEmpty() || curNode != null) {
            if (curNode != null) {
                // 延左子树向下寻找【1】
                stack.push(curNode);
                curNode = curNode.left;
            } else {
                // curNode == null 表示左子树遍历到头/正在出栈
                curNode = stack.peek(); // 先不弹出，可能是第一次访问
                if (curNode.right == null || curNode.right == lastPopNode) {
                    // 没有右子树/右子树已访问过【3】
                    stack.pop(); // 可以弹出
                    lastPopNode = curNode;
                    result.add(curNode.val);
                    curNode = null; // 注意要把curNode置空
                } else {
                    // 有右子树且右子树未被访问过【2】
                    curNode = curNode.right; // 进入右子树
                }
            }
        }
        return result;
    }

    /**
     * *************************************** 自研傻逼迭代解法，遍历完清空子节点关联
     */
    private Stack<TreeNode> mNodeStack = new Stack<>();

    private List<Integer> postOrderTraverseIterate_1(TreeNode root) {
        List<Integer> intList = new ArrayList<Integer>();
        if (root == null) {
            return intList;
        }
        TreeNode curNode = root;
        pushLeftNodes(curNode);
        while (!mNodeStack.empty()) {
            curNode = mNodeStack.pop();
            if (curNode.right != null) {
                pushLeftNodes(curNode);
                curNode.right = null;
            } else {
                intList.add(curNode.val);
            }
        }
        return intList;
    }

    /**
     * 找到最左下方节点,并将路径上的节点入栈
     */
    private void pushLeftNodes(TreeNode inputNode) {
        TreeNode node = inputNode;
        mNodeStack.push(node);
        while (node.left != null || node.right != null) {
            if (node.left != null) {
                TreeNode tmp = node;
                node = node.left;
                tmp.left = null;
            } else {
                TreeNode tmp = node;
                node = node.right;
                tmp.right = null;
            }
            mNodeStack.push(node);
        }
    }
}
