package leetcode;


/**
 * 2038. 如果相邻两个颜色均相同则删除当前颜色
 */
public class Solution_2038 {

    public static void main(String[] args) {
        new Solution_2038().winnerOfGame("AAABABB");
    }

    /**
     * 看题解去
     * @param colors
     * @return
     */
    public boolean winnerOfGame(String colors) {
        StringBuilder sb = new StringBuilder(colors);
        boolean alice = handleChar(sb, 'A');
        boolean bob = handleChar(sb, 'B');
        while (alice && bob) {
            alice = handleChar(sb, 'A');
            bob = handleChar(sb, 'B');
        }
        if (!alice) {
            return false; //bob赢
        }
        return true; // alice赢
    }

    /**
     * 处理目标字符，找到最长的连续字符中间位置切割为最优解法
     *
     * @param sb
     * @param targetChar
     * @return
     */
    private boolean handleChar(StringBuilder sb, char targetChar) {
        int startIndex = 0;
        int maxLength = 0;
        int curLength = 0;
        int curStartIndex = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == targetChar) {
                if (curLength == 0) {
                    curLength = 1;
                    curStartIndex = i;
                } else {
                    curLength++;
                }
                if (curLength > maxLength) {
                    startIndex = curStartIndex;
                    maxLength = curLength;
                }
            } else {
                curStartIndex = 0;
                curLength = 0;
            }
        }
        if (maxLength > 2) {
            sb.deleteCharAt(startIndex + (maxLength - 1) / 2);
            System.out.println(targetChar + " handle success! final string:" + sb);
            return true;
        } else {
            System.out.println(targetChar + " handle fail! final string:" + sb);
            return false;
        }
    }
}
