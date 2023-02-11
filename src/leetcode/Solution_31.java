package leetcode;

import leetcode.sort.SortAlg;

public class Solution_31 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2};
        new Solution_31().nextPermutation(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int i = nums.length - 1;
        for (; i >= 0; i--) {
            if (i == 0 || nums[i - 1] < nums[i]) {
                //数组为降序 || 找到i-1比i小得组合
                break;
            }
        }
        // 数组为降序直接返回升序排列
        if (i == 0) {
//            SortAlg.quickSort(nums, 0, nums.length - 1);
            // 降序直接反转
            reverse(nums, 0);
            return;
        }
        // 找到i之后的列表中，从后往前第一个比i-1大的位置
        int left = i - 1;
        int right = nums.length - 1;
        for (; right >= i; right--) {
            if (nums[right] > nums[left]) {
                break;
            }
        }
        switchIndex(nums, left, right);
//        SortAlg.quickSort(nums, i, nums.length - 1);
        // 优化解法，因为i之后的必定是降序,只需要反转即可
        reverse(nums, i);
    }

    private void switchIndex(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    /**
     * 反转
     */
    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            switchIndex(nums, left, right);
            left++;
            right--;
        }
    }
}
