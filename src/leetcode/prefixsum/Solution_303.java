package leetcode.prefixsum;

/**
 * 303. 区域和检索 - 数组不可变
 */
public class Solution_303 {
    class NumArray {

        int[] prefixSum;

        public NumArray(int[] nums) {
            if (nums == null) {
                return;
            }
            prefixSum = new int[nums.length + 1];
            int total = 0;
            prefixSum[0] = 0;
            for (int i = 1; i < prefixSum.length; i++) {
                total += nums[i - 1];
                prefixSum[i] = total;
            }
        }

        public int sumRange(int left, int right) {
            return prefixSum[right + 1] - prefixSum[left];
        }
    }
}
