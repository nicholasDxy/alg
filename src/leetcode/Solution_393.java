package leetcode;

import leetcode.binarysearch.Solution_145;

/**
 * 393. UTF-8 编码验证
 */
public class Solution_393 {


    public static void main(String[] args) {
        new Solution_393().validUtf8(new int[]{197, 130, 1});
    }

    /**
     * 【1】确认位数
     * 【2】判断后面的格式是否正确
     * 注意边界场景
     */
    public boolean validUtf8(int[] data) {
        int firstBit = 1 << 7; // 判断第一位是否是1标志位
        int index = 0;
        while (index < data.length) {
            int curData = data[index];
            int bitNums = 0;// 计算字符位数
            while ((curData & firstBit) == firstBit) {
                curData = curData << 1;
                bitNums++;
            }
            if (bitNums == 0) {
                // 单字节
                index++;
            } else if (bitNums > 4 || bitNums == 1) {
                // 字节超长/10开头
                return false;
            } else {
                int nextIndex = index + bitNums; // 下一个index
                // 验证多个字符
                bitNums--;
                if (index + bitNums >= data.length) {
                    return false;
                }
                while (bitNums > 0) {
                    curData = data[index + bitNums];
                    if ((curData & firstBit) == firstBit & ((curData << 1) & firstBit) != firstBit) {
                        bitNums--;
                        continue;
                    }
                    return false;
                }
                index = nextIndex;
            }
        }
        return true;
    }
}
