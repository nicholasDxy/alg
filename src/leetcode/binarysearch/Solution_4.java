package leetcode.binarysearch;

/**
 * 4.寻找两个正序数组的中位数
 * O(log (m+n))-->二分法
 * 递归找地k/2,每次舍弃一半
 * 两个数中第k大的数，两个数组取前k/2,如果第一个数组的k/2比第二个数组的k/2小，说明第K大的数一定不在第一个数组的前k/2中，则可以舍去第一个数组的k/2，取剩余数组中第k-k/2大的数
 */
public class Solution_4 {
    /**
     * 我的傻逼做法，这里的复杂度为O(m+n)而非O(log(m+n))，想要达到log必须要用二分法
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int totalLength = m + n;
        int curIndex1 = 0;
        int curIndex2 = 0;
        int curLength = 0;
        int lastNode = Integer.MIN_VALUE;
        while (curIndex1 < m || curIndex2 < n) {
            int curNode;
            if (curIndex1 < m && curIndex2 < n) {
                if (nums1[curIndex1] < nums2[curIndex2]) {
                    curNode = nums1[curIndex1];
                    curIndex1++;
                } else {
                    curNode = nums2[curIndex2];
                    curIndex2++;
                }
            } else if (curIndex1 < m) {
                curNode = nums1[curIndex1];
                curIndex1++;
            } else {
                curNode = nums2[curIndex2];
                curIndex2++;
            }
            curLength++;
            if (curLength * 2 - totalLength == 2) {
                // m+n 为偶数，这个和上一个
                return (float) (curNode + lastNode) / 2;
            } else if (curLength * 2 - totalLength == 1) {
                // m+n 为奇数，这个
                return curNode;
            }
            lastNode = curNode;
        }
        return 0;
    }

    /**
     * 题解方法，使用二分，注意边界处理：数组为空，数组达不到二分，k=1
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays_1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        return (findMiddle(nums1, nums2, 0, 0, (m + n + 1) / 2) + findMiddle(nums1, nums2, 0, 0, (m + n + 2) / 2)) / 2;
    }

    /**
     * 二分法查找第k大的数
     * k的取值为[1,(m+n)]，表示第k大的数，k不可以为0，所以k=1的时候不能二分，要特殊处理
     * @param nums1
     * @param nums2
     * @param num1Index
     * @param num2Index
     * @param k
     * @return
     */
    public double findMiddle(int[] nums1, int[] nums2, int num1Index, int num2Index, int k) {
        int middle = k / 2;
        if (num1Index >= nums1.length) {
            // 第一个数组到头，直接取第二个数组
            return nums2[num2Index + k - 1];
        }
        if (num2Index >= nums2.length) {
            return nums1[num1Index + k - 1];
        }
        // 注意剩一个的情况!!这里如果不处理的话就会使得 k/2 = 0，导致选取越界
        if (k ==1) {
            return Math.min(nums1[num1Index], nums2[num2Index]);
        }
        if (num1Index + middle > nums1.length) {
            // nums1不足k/2，说明第k大的必定不在nums2的前k/2中
            num2Index += middle;
            return findMiddle(nums1, nums2, num1Index, num2Index, k - middle);
        }
        if (num2Index + middle > nums2.length) {
            // nums2不足k/2，说明第k大的必定不在nums1的前k/2中
            num1Index += middle;
            return findMiddle(nums1, nums2, num1Index, num2Index, k - middle);
        }
        int nums1kMiddle = nums1[num1Index + middle - 1];
        int num2kMiddle = nums2[num2Index + middle - 1];
        if (nums1kMiddle > num2kMiddle) {
            num2Index += middle;
        } else {
            num1Index += middle;
        }
        return findMiddle(nums1, nums2, num1Index, num2Index, k - middle);

    }
}
