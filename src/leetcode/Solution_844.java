package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 844. 比较含退格的字符串
 */

public class Solution_844 {

    public static void main(String[] args) {
        new Solution_844().backspaceCompare("y#fo##f", "y#f#o##f");
    }

    public boolean backspaceCompare(String s, String t) {
        return useStack(s, t);
    }

    /**
     * double pointer
     */
    private boolean doublePointer(String s, String t) {
        int indexS = s.length() - 1, indexT = t.length() - 1;
        int sDeleteLength = 0, tDeleteLength = 0;
        while (indexS >= 0 || indexT >= 0) {
            while (indexS >= 0) {
                if (s.charAt(indexS) == '#') {
                    sDeleteLength++;
                } else if (sDeleteLength > 0) {
                    sDeleteLength--;
                } else {
                    break;
                }
                indexS--;
            }
            while (indexT >= 0) {
                if (t.charAt(indexT) == '#') {
                    tDeleteLength++;
                } else if (tDeleteLength > 0) {
                    tDeleteLength--;
                } else {
                    break;
                }
                indexT--;
            }
//            if (indexS < 0 && indexT < 0) {
//                return true;
//            }
//            if (indexS < 0 && indexT >= 0 || indexS >= 0 && indexT < 0 || s.charAt(indexS) != t.charAt(indexT)) {
//                return false;
//            }
            // 他妈的判断优化
            if (indexS >= 0 && indexT >= 0) {
                if(s.charAt(indexS) != t.charAt(indexT)) {
                    return false;
                }
            } else if (indexS >= 0 || indexT >= 0) {
                return false;
            }
            indexS--;
            indexT--;
        }
        return true;
    }


    /**
     * stack
     */
    private boolean useStack(String s, String t) {
        return obtainRealStr(s).equals(obtainRealStr(t));
    }

    private String obtainRealStr(String s) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < s.length()) {
            if (s.charAt(index) == '#') {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(s.charAt(index));
            }
            index++;
        }
        return sb.toString();
    }
}


