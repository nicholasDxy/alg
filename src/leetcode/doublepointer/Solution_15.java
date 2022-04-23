package leetcode.doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 */
public class Solution_15 {

    public static void main(String[] args) {
        System.out.println(new Solution_15().threeSum(new int[]{0}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    // 找到和等于0， 但是要去重
                    while (nums[left] == nums[left + 1] && left + 1 < right) {
                        left++;
                    }
                    while (nums[right] == nums[right - 1] && right - 1 > left) {
                        right--;
                    }
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

//    List<Integer> list = new ArrayList<>();
//    List<List<Integer>> result = new ArrayList<>();
//
//    public void threeSum_backTrack(int[] nums, int startIndex) {
//        if (list.size() == 3) {
//            if (list.get(0) + list.get(1) + list.get(2) == 0) {
//                result.add(new ArrayList<>(list));
//            }
//            return;
//        }
//        if (startIndex >= nums.length) {
//            return;
//        }
//        for (int i = startIndex; i < nums.length; i++) {
//            list.add(nums[i]);
//            threeSum_backTrack(nums, i + 1);
//            list.remove(list.size() - 1);
//        }
//    }
}
