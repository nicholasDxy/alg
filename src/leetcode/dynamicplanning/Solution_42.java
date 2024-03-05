package leetcode.dynamicplanning;

/** 42. Trapping Rain Water **/

public class Solution_42 {
    public int trap(int[] height) {
        int[] rightMax = new int[height.length];
        int max = 0;
        for (int i = height.length-1;i>=0;i--) {
            if (height[i]>max) {
                max = height[i];
            }
            rightMax[i] = max;
        }
        max = 0;
        int trap = 0;
        for (int i = 0; i<height.length;i++) {
            if (max<rightMax[i]) {
                if (height[i]<max) {
                    trap += max-height[i];
                }
            } else {
                if (height[i]<rightMax[i]) {
                    trap += rightMax[i]-height[i];
                }
            }
            if (height[i]>max) {
                max = height[i];
            }
        }
        return  trap;
    }

}
