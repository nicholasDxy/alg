package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 720. 词典中最长的单词
 */
public class Solution_720 {

    public static void main(String[] args) {
        new Solution_720().longestWord(new String[]{"yo", "ew", "fc", "zrc", "yodn", "fcm", "qm", "qmo", "fcmz", "z", "ewq", "yod", "ewqz", "y"});
    }

    public String longestWord(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        String curStr = null;
        String subStr = null;
        int maxLength = 0;
        String maxString = "";
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], 0);
        }
        for (int i = 0; i < words.length; i++) {
            curStr = words[i];
            boolean isValid = true;
            for (int index = 1; index < curStr.length(); index++) {
                if (!map.containsKey(curStr.substring(0, index))) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                if (curStr.length() > maxLength) {
                    maxLength = curStr.length();
                    maxString = curStr;
                } else if (curStr.length() == maxLength) {
                    maxString = compareStrByDic(curStr, maxString);
                }
            }
        }
        return maxString;
    }

    private String compareStrByDic(String str1, String str2) {
        int index = 0;
        while (index < str1.length() && index < str2.length()) {
            if (str1.charAt(index) < str2.charAt(index)) {
                return str1;
            } else if (str1.charAt(index) > str2.charAt(index)) {
                return str2;
            }
            index++;
        }
        if (index < str1.length()) {
            return str2;
        }
        return str1;
    }
}
