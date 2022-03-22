package leetcode.tree.bst;

import leetcode.tree.TreeNode;

/**
 * 653. 两数之和 IV - 输入 BST
 */
public class Solution_653 {
    public static void main(String[] args) {
        new Solution_653().findTarget(new TreeNode(1),2);
    }

    public boolean findTarget(TreeNode root, int k) {
        return bfs(root, root, k);
    }

    /**
     * 遍历查找
     */
    private boolean bfs(TreeNode root, TreeNode curNode, int k) {
        if (curNode == null) {
            return false;
        }
        int diff = k - curNode.val;
        if (diff == curNode.val) {
            return bfs(root, curNode.left, k) || bfs(root, curNode.right, k);// 二叉搜索树中不存在相同节点
        }
        if (findTargetNum(root, diff)) {
            return true;
        }
        return bfs(root, curNode.left, k) || bfs(root, curNode.right, k);
    }

    /**
     * 查找节点
     */
    private boolean findTargetNum(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (root.val == k) {
            return true;
        } else if (root.val < k) {
            return findTargetNum(root.right, k);
        } else {
            return findTargetNum(root.left, k);
        }
    }
}
