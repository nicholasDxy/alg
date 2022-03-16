package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 2044. 统计按位或能得到最大值的子集数目
 */
public class Solution_2044 {
    public static void main(String[] args) {
        System.out.println(new Solution_2044().countMaxOrSubsets(new int[]{2, 2, 2}));
    }

    public int countMaxOrSubsets(int[] nums) {
        int maxNum = 0;
        for (int index = 0; index < nums.length; index++) {
            maxNum |= nums[index];
        }
        return backTrackPlus(nums, 0, 0, maxNum);
    }

    /**
     * 最优解法
     */
    private int backTrackPlus(int[] nums, int curIndex, int curOr, int max) {
        if (curOr == max) {
            // 符合结果，返回所有可能，此时curIndex为满足curOr的index+1
            return 1 << (nums.length - curIndex);// 组合计算
        }
        if (curIndex == nums.length) {
            //到最后没找到符合标准的
            return 0;
        }
        return backTrackPlus(nums, curIndex + 1, curOr, max) // 不选择这个
                + backTrackPlus(nums, curIndex + 1, curOr | nums[curIndex], max); // 选择这个
    }

    /**
     * 自己根据回溯法想的，没有从本质看待问题
     */
    int mResultNum = 0;
    List<Integer> mPath = new ArrayList<>();

    private void backTrack(int[] nums, int maxNum, int startIndex) {
        for (int index = startIndex; index < nums.length; index++) {
            mPath.add(nums[index]);
            if (getOrNum(mPath) == maxNum) {
//                mResultNum++;
                //已经满足最大，则后面剩余数字任意排列组合都满足
                int leftNum = nums.length - (index + 1); // 这里注意index是从0开始的，算长度的时候要+1
                mResultNum += Math.pow(2, leftNum);
                // 符合标准后直接遍历下一个index，不需要递归当前的子选择了
                mPath.remove(mPath.size() - 1); // 记得删除当前选择
                continue;
            }
            //递归子选择
            backTrack(nums, maxNum, index + 1);
            mPath.remove(mPath.size() - 1);
        }
    }

    private int getOrNum(List<Integer> path) {
        int orNum = 0;
        for (int index = 0; index < path.size(); index++) {
            orNum |= path.get(index);
        }
        return orNum;
    }
}
