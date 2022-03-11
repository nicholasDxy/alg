package leetcode;

/**
 * 7. 整数反转
 * 对溢出的判断
 */
public class Solution_7 {
    public int reverse(int x) {
        int result = 0;
        int lastPosNum = Integer.MAX_VALUE % 10;
        int lastNegNum = Integer.MIN_VALUE % 10;
        int posFlag = Integer.MAX_VALUE / 10;
        int negFlag = Integer.MIN_VALUE / 10;
        while (x != 0) {
            int tmp = x % 10;
            if (result > posFlag || result == posFlag && tmp > lastPosNum) {
                return 0;
            }
            if (result < negFlag || result == negFlag & x < lastNegNum) {
                return 0;
            }
            result = result * 10 + tmp;
            x /= 10;
        }
        return result;
    }
}
