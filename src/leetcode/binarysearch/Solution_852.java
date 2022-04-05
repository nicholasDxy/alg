package leetcode.binarysearch;

/**
 * 852. 山脉数组的峰顶索引
 */
public class Solution_852 {
    public static void main(String[] args) {
        new Solution_852().peakIndexInMountainArray(new int[]{24,69,100,99,79,78,67,36,26,19});
    }

    public int peakIndexInMountainArray(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int mid = start + end >> 1;
            if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
