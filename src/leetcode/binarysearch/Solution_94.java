package leetcode.binarysearch;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution_94 {



    public List<Integer> inorderTraversal(TreeNode root) {
        inorderRecursion(root);
        return mIntegerList;
    }

    /**
     ************************ recursion *******************
     */

    private List<Integer> mIntegerList = new ArrayList<Integer>();
    private void inorderRecursion(TreeNode root) {
        if(root == null) {
            return;
        }
        inorderRecursion(root.left);
        mIntegerList.add(root.val);
        inorderTraversal(root.right);
    }

    /**
     * *********************** Iterate *********************
     */

    /**
     * 中序遍历迭代法
     * 注意curNode的置空，不为空时为入栈过程，为空时为出栈过程
     * 迭代流程：
     * 【1】将路径上的节点入栈直到node.left为空
     * 【2】弹出栈顶节点，写入结果
     * 【3】如果有右节点，则右节点入栈
     */
    private List<Integer> inorderIterate(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> resultList = new ArrayList<>();
        TreeNode curNode = root;
        while (!stack.isEmpty() || curNode != null) {
            if (curNode != null) {
                //【1】
                stack.push(curNode);
                curNode = curNode.left;
            } else {
                // 节点为空，进行出栈【2】
                curNode = stack.pop();
                resultList.add(curNode.val);
                if (curNode.right != null) {
                    //【3】
                    curNode = curNode.right;
                } else {
                    // 没有右节点时要置空，下一个元素从栈内拿
                    curNode = null;
                }
            }
        }
        return resultList;
    }
}
