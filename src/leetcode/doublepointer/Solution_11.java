package leetcode.doublepointer;

/**
 * 11. 盛最多水的容器
 */
public class Solution_11 {
//    public int maxArea(int[] height) {
//        int maxNum = 0;
//        for (int i = 0; i < height.length; i++) {
//            int curMax = 0;
//            for (int j = height.length - 1; j > i; j--) {
//                int max = Math.min(height[j], height[i]) * (j - i);
//                if (max > curMax) {
//                    curMax = max;
//                    if (height[j] >= height[i]) {
//                        break;
//                    }
//                }
//            }
//            if (curMax > maxNum) {
//                maxNum = curMax;
//            }
//        }
//        return maxNum;
//    }

    public int maxArea(int[] height) {
        int startIndex = 0, endIndex = height.length - 1, max = 0;
        while (startIndex < endIndex) {
            int curMax;
            if (height[startIndex] < height[endIndex]) {
                curMax = height[startIndex] * (endIndex - startIndex);
                startIndex++;
            } else {
                curMax = height[endIndex] * (endIndex - startIndex);
                endIndex--;
            }
            if (curMax > max) {
                max = curMax;
            }
        }
        return max;
    }
}
