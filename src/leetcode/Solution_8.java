package leetcode;

/**
 *8. 字符串转换整数 (atoi)
 * 注意正负号
 * 注意溢出
 */
public class Solution_8 {
    public int myAtoi(String s) {
        if (s == null && s.length() < 1) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int index = 0;
        int result = 0;
        int posFlag = 1;
        // step1
        while (index < chars.length && chars[index] == ' ') {
            index++;
        }
        // step2
        if (index < chars.length && chars[index] == '-') {
            posFlag = -1;
            index++;
        } else if (index < chars.length && chars[index] == '+') {
            index++;
        }
        // step3
        int posMinus10 = Integer.MAX_VALUE / 10;
        int postLastNum = Integer.MAX_VALUE % 10;
        int negMinus10 = Integer.MIN_VALUE / 10;
        int negLastNum = Integer.MIN_VALUE % 10;
        while (index < chars.length && '0' <= chars[index] && chars[index] <= '9') {
            int num = chars[index] - '0';
            num*= posFlag; // reset sign
            //check overflow
            if (result > posMinus10 || result == posMinus10 && num > postLastNum) {
                return Integer.MAX_VALUE;
            }
            if (result < negMinus10 || result == negMinus10 && num < negLastNum) {
                return Integer.MIN_VALUE;
            }
            result = result * 10 + num;
            index++;
        }
        return result;
    }
}
