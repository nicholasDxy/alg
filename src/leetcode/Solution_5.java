package leetcode;

/**
 * 5. 最长回文子串
 * 字符串处理的题要将string转成charArray。提高取字符速度
 */
public class Solution_5 {
    public static void main(String[] args) {
        Solution_5 solution5 = new Solution_5();
        System.out.println(solution5.longestPalindrome_2round("cbbd"));
    }
    public String longestPalindrome_2round(String s) {
        char[] charList = s.toCharArray();
        int maxLength = 0;
        String result  = null;
        for (int i = 0; i<s.length();i++) {
            int left = i-1, right =i+1;
            while(right<s.length() && charList[i] == charList[right]) {
                right += 1;
            }
            while (left>=0 && right<charList.length) {
                if (charList[left] != charList[right]) {
                    break;
                }
                left--;
                right++;
            }
            int lengthTemp = right - left -1;
            if (lengthTemp>maxLength) {
                maxLength = lengthTemp;
                result = s.substring(left+1,right);
            }
        }
        return result;
    }

    public String longestPalindrome(String s) {
        return violentSolution(s);
    }


    /**
     * 回文特点，中间对称，中间可以有多个相同字符，要找到左右开始扩散的节点
     * @param s
     * @return
     */
    public String solution(String s) {
        int start = 0;
        int end = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && charArray[left] ==charArray[i]) {
                //左边第一个不同的字符
                left--;
            }
            while (right < s.length() && charArray[right] == charArray[i]) {
                // 右边第一个不同的字符
                right++;
            }
            while (left >= 0 && right < s.length() && charArray[left] == charArray[right]) {
                // 符合回文规则就继续向两边扩散
                left--;
                right++;
            }
            left++;
            right--;
            if (right - left > end - start) {
                start = left;
                end = right;
            }
        }
        return s.substring(start, end + 1);

    }

    /**
     * 超出时间复杂度了
     *
     * @param s
     * @return
     */
    public String violentSolution(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int startIndex = 0;
        int finishIndex = 0;
        int maxLength = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j > i; j--) {
                if (s.charAt(j) == s.charAt(i)) {
                    int start = i + 1;
                    int end = j - 1;
                    boolean isPalindrome = true;
                    while (end > start) {
                        if (s.charAt(start) != s.charAt(end)) {
                            isPalindrome = false;
                            break;
                        }
                        end--;
                        start++;
                    }
                    if (isPalindrome && j - i + 1 > maxLength) {
                        startIndex = i;
                        finishIndex = j;
                        maxLength = j - i + 1;
                    }
                }
            }
        }
        return s.substring(startIndex, finishIndex + 1);
    }
}
