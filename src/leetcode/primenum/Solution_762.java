package leetcode.primenum;

import java.util.Arrays;

/**
 * 762. 二进制表示中质数个计算置位
 */
public class Solution_762 {

    public static void main(String[] args) {
        new Solution_762().countPrimeSetBits(10, 15);
    }

    private boolean[] mPrimeArray = initPrimeArray();

    /**
     * 初始化质数数组
     */
    private boolean[] initPrimeArray() {
        boolean[] array = new boolean[30];
        Arrays.fill(array, true);
        array[0] = false;
        array[1] = false;
        for (int i = 2; i < 30; i++) {
            if (array[i]) {
                int notPrime = i * i;
                while (notPrime < array.length) {
                    array[notPrime] = false;
                    notPrime += i;
                }
            }
        }
        return array;
    }

    public int countPrimeSetBits(int left, int right) {
        int result = 0;
        for (int i = left; i <= right; i++) {
            if (mPrimeArray[get1DigitNum(i)]) {
                result++;
            }
        }
        return result;
    }

    /**
     * 获取num的1个数
     */
    private int get1DigitNum(int num) {
        int digit = 0;
        while (num > 0) {
            digit++;
            num -= lowBit(num);
        }
        return digit;
    }

    /**
     * lowBit获取最后一位1
     */
    private int lowBit(int num) {
        return num & (-num);
    }

}
