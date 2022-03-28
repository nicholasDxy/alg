package leetcode;

/**
 * 2028. 找出缺失的观测数据
 */
public class Solution_2028 {

    public static void main(String[] args) {
        new Solution_2028().missingRolls(new int[]{3, 2, 4, 3}, 4, 2);
    }

    /**
     * 数学模拟
     */
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int totalSum = mean * (rolls.length + n); // 和
        int rollsSum = 0;
        for (int i : rolls) {
            rollsSum += i;
        }
        int resultSum = totalSum - rollsSum; // 丢失数据只和
        float average = (float) resultSum / n; //计算缺失平均值
        if (average < 1 || average > 6) {
            return new int[0]; //超出1-6，返回false
        }
        int[] result = new int[n];
        int floor = (int) Math.floor(average); //计算整数下界
        int left = resultSum - floor * n; //与目标和差距
        int leftNum = floor + 1; // 补足个数
        for (int i = 0; i < n; i++) {
            if (i < left) {
                result[i] = leftNum;
            } else {
                result[i] = floor;
            }
        }
        return result;
    }

    /**
     * 回溯法-暴力解
     */
    public int[] backtrack(int[] rolls, int mean, int n) {
        int totalSum = mean * (rolls.length + n); // 和
        int rollsSum = 0;
        for (int i : rolls) {
            rollsSum += i;
        }
        int resultSum = totalSum - rollsSum; // 丢失数据只和
        mResult = new int[n];
        if (backTrack(0, resultSum, 0)) {
            return mResult;
        }
        return new int[mResult.length];
    }

    private int[] mResult;

    /**
     * 回溯法找到和为resultSum的组合
     *
     * @param sum    当前和
     * @param target 目标和
     * @param index  当前下标
     */
    private boolean backTrack(int sum, int target, int index) {
        int leftIndex = mResult.length - index;
        if (leftIndex + sum > target || leftIndex * 6 + sum < target) {
            //如果剩余次数不可能达到目标和，则直接返回失败
            return false;
        }

        if (index == mResult.length - 1) {
            int leftNum = target - sum;
            if (leftNum >= 1 && leftNum <= 6) {
                //找到符合标准的组合
                mResult[index] = leftNum;
                return true;
            }
            return false;
        }
        for (int i = 1; i <= 6; i++) { //枚举1-6
            mResult[index] = i;
            if (backTrack(sum + i, target, index + 1)) {
                return true; // 已经找到
            }
        }
        return false;
    }
}
