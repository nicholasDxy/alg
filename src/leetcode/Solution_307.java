package leetcode;

/**
 * 307. 区域和检索 - 数组可修改
 */
public class Solution_307 {

    public static void main(String[] args) {
        NumArray array = new NumArray(new int[]{9, -8});
        array.update(0, 3);
        array.sumRange(1, 1);
        array.sumRange(0, 1);
        array.update(1, -3);
        array.sumRange(0, 1);
    }

    static class NumArray {

        private int[] mTreeSum;
        private int[] mArray;

        private int lowBit(int x) {
            return x & (-x);
        }

        public NumArray(int[] nums) {
            mArray = nums;
            mTreeSum = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                int realI = i + 1;
                while (realI <= nums.length) {
                    mTreeSum[realI] += nums[i];
                    realI = realI + lowBit(realI);
                }
            }
        }

        public void update(int index, int val) {
            int diff = val - mArray[index];
            mArray[index] = val;
            int realI = index + 1;
            while (realI <= mArray.length) {
                mTreeSum[realI] += diff;
                realI = realI + lowBit(realI);
            }
        }

        public int sumRange(int left, int right) {
            int result = getPrefixSum(right) - getPrefixSum(left - 1);
            return result;
        }

        private int getPrefixSum(int index) {
            int realI = index + 1;
            int result = 0;
            while (realI > 0) {
                result += mTreeSum[realI];
                realI = realI - lowBit(realI);
            }
            return result;
        }
    }


    /**
     * 前缀和超时了
     */
//    class NumArray {
//        private int[] mArray;
//        private int[] mPrefixSum;
//
//        public NumArray(int[] nums) {
//            mArray = nums;
//            //生成前缀和数组
//            mPrefixSum = new int[nums.length];
//            int sum = 0;
//            for (int i = 0; i < nums.length; i++) {
//                sum += nums[i];
//                mPrefixSum[i] = sum;
//            }
//        }
//
//        public void update(int index, int val) {
//            int diff = val - mArray[index];
//            mArray[index] = val;
//            //更新前缀和数组
//            for (int i = index; i < mArray.length; i++) {
//                mPrefixSum[i] += diff;
//            }
//        }
//
//        public int sumRange(int left, int right) {
//            int leftPrefix = left == 0 ? 0 : mPrefixSum[left - 1];
//            return mPrefixSum[right] - leftPrefix;
//        }
//    }

}
