package leetcode.doublepointer;

/**
 * 11. 盛最多水的容器
 */
public class Solution_11 {

    public static void main(String[] args) {
        Solution_11 s = new Solution_11();
        int[] a = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(s.maxArea_2round(a));
    }

    public int maxArea_2round(int[] height) {
        int start = 0, end = height.length - 1;
        int max = 0, temp = 0;
        while (start < end) {
            if (height[start]<height[end]) {
                temp = height[start] * (end - start);
                if (max<temp) {
                    max = temp;
                }
                int lastStart = height[start];
                while(start<= height.length-1 && height[start]<=lastStart) {
                    start ++;
                }
            } else {
                temp = height[end] * (end - start);
                if (max<temp) {
                    max = temp;
                }
                int lastEnd = height[end];
                while(end >=0 && height[end]<=lastEnd) {
                    end --;
                }
            }
        }
        return max;
    }

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
