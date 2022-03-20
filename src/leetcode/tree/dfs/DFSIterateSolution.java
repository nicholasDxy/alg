package leetcode.tree.dfs;

import leetcode.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class DFSIterateSolution {

    /**
     * 迭代法遍历模板
     * 需要想好：
     * 1、何时写入结果
     * 2、何时进行出栈
     * 注意点：出栈之后curNode要置空，防止重复入栈
     */
    private List<Integer> iterateTemplate(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> resultList = new ArrayList<>();
        TreeNode curNode = root; // 当前节点
        while (!stack.isEmpty() || curNode != null) {
            if (curNode != null) {
               // 左节点入栈过程
            } else {
                // 从栈中取
            }
        }
        return resultList;
    }

    /**
     * 前序遍历迭代
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


}
