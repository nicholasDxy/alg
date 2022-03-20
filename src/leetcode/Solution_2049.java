package leetcode;

import leetcode.tree.TreeNode;

/**
 * 2049. 统计最高分的节点数目
 */
public class Solution_2049 {

    public static void main(String[] args) {
        new Solution_2049().countHighestScoreNodes(new int[]{-1,2,0,2,0});
    }

    // 题解未通过。。。199
    public int countHighestScoreNodes(int[] parents) {
        if (parents == null) {
            return 0;
        }
        if (parents.length <= 2) {
            return parents.length;
        }
        TreeNode[] nodeArray = new TreeNode[parents.length];
        for (int index = 0; index < parents.length; index++) {
            nodeArray[index] = new TreeNode();
        }
        for (int index = 1; index < parents.length; index++) {
            addChild(nodeArray[parents[index]], nodeArray[index]);
        }
        // 寻找个数
        long maxProduct = 0;
        int nums = 0;
        for (int index = 0; index < parents.length; index++) {
            TreeNode curNode = nodeArray[index];
            int leftNum = findNodeNum(curNode.left);
            int rightNum = findNodeNum(curNode.right);
            int remainNum = parents.length - leftNum - rightNum - 1;
            leftNum = leftNum == 0 ? 1 : leftNum;
            rightNum = rightNum == 0 ? 1 : rightNum;
            remainNum = remainNum == 0 ? 1 : remainNum;
            long product = leftNum * rightNum * remainNum;
            if (product > maxProduct) {
                maxProduct = product;
                nums = 1;
            } else if (product == maxProduct) {
                nums++;
            }
        }
        return nums;
    }

    /**
     * 添加子节点
     */
    private void addChild(TreeNode parent, TreeNode child) {
        if (parent.left == null) {
            parent.left = child;
        } else if (parent.right == null) {
            parent.right = child;
        }
    }

    /**
     * 子节点个数
     */
    private int findNodeNum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return findNodeNum(node.left) + findNodeNum(node.right) + 1;
    }
}
