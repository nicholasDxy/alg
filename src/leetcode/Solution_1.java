package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * 遍历得到和--》找每个数的差
 */
public class Solution_1 {

    public int[] twoSum_1(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1;j<nums.length;j++) {
                if(nums[i] +nums[j]==target) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public int[] twoSum_2(int[] nums, int target) {
        Map<Integer,Integer> numsMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            final int diff =  target - nums[i];
            if (numsMap.containsKey(diff)) {
                return new int[]{i,numsMap.get(diff)};
            }
            numsMap.put(nums[i],i);
        }
        return null;
    }
}
