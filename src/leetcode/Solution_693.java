package leetcode;

/**
 * 693. 交替位二进制数
 */
public class Solution_693 {
    public boolean hasAlternatingBits(int n) {
        if (n <= 2) {
            return true;
        }
        int lastDigit = n % 2;
        int curDigit;
        while(n>0) {
            n/=2;
            curDigit = n%2;
            if (curDigit == lastDigit) {
                return false;
            }
            lastDigit = curDigit;
        }
        return true;
    }
}
