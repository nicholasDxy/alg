package leetcode.tree.dictree;

/**
 * 440. 字典序的第K小数字
 */
public class Solution_440 {

    public static void main(String[] args) {
        System.out.println(new Solution_440().findKthNumber(
                681692778, 351251360));
    }

    public int findKthNumber(int n, int k) {
        return dicOrder(n, k);
    }


    /**
     * ****************************************字典序*********************************
     */

    public int dicOrder(int n, int k) {
        int curPreFix = 1; // 当前前缀
        int curRank = 0; // 这个计数为记录当前前缀之前的所有前缀枚举数量，当前前缀为curRank+1个
        while (true) {
            if (curRank== k-1) {
                break;  // curPreFix为当前的前缀，curRank为当前前缀之前的所有数量，不包含当前前缀，所以如果当前curRank==k-1则说明当前为答案
            }
            int curPreFixNum = getPrefixNum(curPreFix, n); // 寻找当前前缀的[1,n]中个数
            if (curRank + curPreFixNum >= k) { // curRank为当前前缀之前的所有枚举数量，curPreFixNum为当前前缀所有枚举数量，max在当前前缀下，向下寻找。
                curRank++; // 自增当前的次序
                curPreFix *= 10; // 进入下一层
            } else { // max不在当前前缀下，向右寻找
                curRank += curPreFixNum; // 当前前缀所有数量加入次序
                curPreFix++; //向右寻找下一个前缀
            }
        }
        return curPreFix;
    }

    /**
     * 寻找前缀到最大值之间的个数
     *
     * @param prefix 前缀
     * @param max    最大值
     * @return
     */
    private int getPrefixNum(int prefix, int max) {
        int curLevelNum = 1; //当前位数下以当前前缀开头的数量
        long curNum = prefix; // 遍历当前值，可能会溢出，要用long
        int totalNum = 0;    // 返回数量
        while (curNum <= max) {
            totalNum += Math.min(curLevelNum, max - curNum + 1); // 如果max在当前层，返回max到curNum的个数；否则返回当前前缀位数下所有个数
            curNum *= 10;     // 当前前缀进入下一层
            curLevelNum *= 10; // 下一个前缀进入下一层
        }
        return totalNum;
    }

    /**
     * ****************************************暴力枚举匹配*********************************
     */

    public int violent(int n, int k) {
        int digit = getDigit(n);
        mNum = new int[digit];
        for (int i = 0; i < digit; i++) {
            mNum[i] = -1;
        }
        backtrack(0, digit, k, n);
        return transArrayToInt();
    }

    private int getDigit(int n) {
        int digitNum = 0;
        int curNum = n;
        while (curNum != 0) {
            digitNum++;
            curNum /= 10;
        }
        return digitNum;
    }

    private int transArrayToInt() {
        int result = 0;
        for (int i : mNum) {
            if (i == -1) {
                break;
            }
            result *= 10;
            result += i;
        }
        return result;
    }

    private int[] mMaxNum;
    private int[] mNum;
    private int mCurNum = 0;

    private boolean backtrack(int curIndex, int digit, int targetNum, int maxNum) {
        if (curIndex == digit) {
            return false;
        }
        int startNum = curIndex == 0 ? 1 : 0; //确定起始数字（首位不为0）
        for (int i = startNum; i <= 9; i++) {
            mNum[curIndex] = i;
            if (curIndex == digit - 1 && transArrayToInt() > maxNum) {
                return false; // 如果是最后一位，检查是否超出最大值
            }
            mCurNum++;
            printMNum();
            if (mCurNum == targetNum) {
                return true; // 找到答案
            }
            if (backtrack(curIndex + 1, digit, targetNum, maxNum)) {
                return true; // 子递归中已经找到答案，当前的mNum为结果，直接返回
            }
            if (curIndex < digit - 1) {// 判断是否为最后一位
                mNum[curIndex + 1] = -1; // 清理数据
            }
        }
        return false;
    }

    private void printMNum() {
        System.out.print("curRank:" + mCurNum + " cur;Num:");
        for (int j : mNum) {
            System.out.print(j + "");
        }
        System.out.println();
    }

}
