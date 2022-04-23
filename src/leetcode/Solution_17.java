package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 */
public class Solution_17 {

    public static void main(String[] args) {
        System.out.println(new Solution_17().letterCombinations("23"));
    }

    char[][] numMap = new char[][]{{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
            {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return result;
        }
        backTrack(digits, 0);
        return result;
    }

    StringBuilder sb = new StringBuilder();
    List<String> result = new ArrayList<>();

    private void backTrack(String digits, int digitIndex) {
        if (digitIndex == digits.length()) {
            result.add(sb.toString());
            return;
        }
        char[] curCharMap = numMap[digits.charAt(digitIndex) - '0']; //得到数字，对应的char[]
        for (int i = 0; i < curCharMap.length; i++) {
            sb.append(curCharMap[i]);
            backTrack(digits, digitIndex + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
