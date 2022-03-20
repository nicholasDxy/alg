package leetcode.tree.dfs;

import leetcode.tree.TreeNode;

import java.util.*;

/**
 * 144. 二叉树的前序遍历
 */

public class Solution_144 {

    private List<Integer> mIntegerList = new ArrayList<Integer>();

    public List<Integer> preorderTraversal(TreeNode root) {
        preOrderTraverseRecursion(root);
        return mIntegerList;
    }

    /**
     * **************************** 递归解法
     */
    private void preOrderTraverseRecursion(TreeNode root) {
        if (root == null) {
            return;
        }
        mIntegerList.add(root.val);
        preOrderTraverseRecursion(root.left);
        preOrderTraverseRecursion(root.right);

    }

    /**
     ***************** 统一迭代法
     * 【1】将路径上的节点入栈，并写入结果，直到node.left为空
     * 【2】弹出栈顶节点，并继续右节点【1】操作
     */
    private List<Integer> preOrderIterate(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> resultList = new ArrayList<>();
        TreeNode curNode = root;
        while (!stack.isEmpty() || curNode != null) {
            if (curNode != null) {
                stack.push(curNode);
                resultList.add(curNode.val);
                curNode = curNode.left;
            } else {
                // 从栈中取
                curNode = stack.pop();
                curNode = curNode.right;
            }
        }
        return resultList;
    }


    /**
     * ***************************** 迭代解法
     */
    private List<Integer> preOrderTraverseIterate(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        if (root == null) {
            return result;
        }
        nodeStack.push(root);
        while (!nodeStack.empty()) {
            TreeNode tmp = nodeStack.pop();
            result.add(tmp.val);
            if (tmp.right != null) {
                nodeStack.push(tmp.right);
            }
            if (tmp.left != null) {
                nodeStack.push(tmp.left);
            }
        }
        return result;
    }
}
