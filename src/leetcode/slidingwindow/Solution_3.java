package leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * 理解无重复和无连续重复，注意读题
 * 滑动窗口思想
 */
public class Solution_3 {
    public int lengthOfLongestSubstring(String s) {
        //搞成连续字符了
        if (s==null ||s.isEmpty()) {
            return 0;
        }
        int curIndex = 1;
        char lastChar = s.charAt(0);
        int maxLength = 0;
        int curLength = 0;
        while(curIndex<s.length()) {
            char curChar = s.charAt(curIndex);
            if (curChar==lastChar) {
                if(curLength>maxLength) {
                    maxLength = curLength;
                }
                curLength = 0;
            } else {
                curLength++;
            }
            lastChar = curChar;
            curIndex++;
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring_1(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        int curIndex = 0;
        int continuousIndex = 0;
        int maxLength = 0;
        while(curIndex<s.length()) {
            char curChar = s.charAt(curIndex);
            if(charMap.containsKey(curChar) && charMap.get(curChar)>=continuousIndex) {
                int curLength = curIndex - continuousIndex;
                continuousIndex = charMap.get(curChar) +1 ;
                maxLength = maxLength<curLength?curLength:maxLength;
            }
            charMap.put(curChar, curIndex);
            curIndex++;
        }
        int curLength = curIndex - continuousIndex;
        maxLength = maxLength<curLength?curLength:maxLength;
        return maxLength;
    }
}
