package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 * 回溯法
 */
public class Solution_77 {
    public List<List<Integer>> combine(int n, int k) {
        backTrackingPlus(n, k, 1);
        return mResult;
    }

    private List<Integer> mPath = new ArrayList<>();
    private List<List<Integer>> mResult = new ArrayList<>();

    /**
     * 回溯法
     * 一个数组，从数组中取数，可以想象一个一一对应的选择数组，为0代表不选为1，代表选中。
     * 理解为遍历所有情况找到所有k个1的组合
     *
     * @param n
     * @param k
     * @param startIndex
     */
    private void backTracking(int n, int k, int startIndex) {
        if (mPath.size() == k) {
            mResult.add(new ArrayList<>(mPath));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            //从startIndex开始向后遍历选择一个数，并进入下一次递归
            mPath.add(i);
            backTracking(n, k, i + 1);
            //取完一种情况后，需要把上一次选中的清除
            mPath.remove(mPath.size() - 1);
        }
    }

    /**
     * 回溯法+剪枝
     * 一个数组，从数组中取数，可以想象一个一一对应的选择数组，为0代表不选为1，代表选中。
     * 理解为遍历所有情况找到所有k个1的组合
     *
     * @param n
     * @param k
     * @param startIndex
     */
    private void backTrackingPlus(int n, int k, int startIndex) {
        if (mPath.size() == k) {
            mResult.add(new ArrayList<>(mPath));
            return;
        }
        int leftNum = k - mPath.size();
        for (int i = startIndex; i <= n - (leftNum) + 1; i++) {
            //从startIndex开始向后遍历选择一个数，并进入下一次递归
            mPath.add(i);
            backTrackingPlus(n, k, i + 1);
            //取完一种情况后，需要把上一次选中的清除
            mPath.remove(mPath.size() - 1);
        }
    }
}
