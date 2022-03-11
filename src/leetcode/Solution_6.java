package leetcode;

/**
 * 6. Z 字形变换
 *
 * 二维数组[y][x]!!
 * 遍历名称不能混用！
 */

public class Solution_6 {

    public static void main(String[] args) {
        System.out.println(new Solution_6().convert("PAYPALISHIRING", 3));
    }

    public String convert(String s, int numRows) {
        return mySolution(s, numRows);
    }

    public String mySolution(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        int lengthOffset = numRows + numRows - 2;
        int listNumsInZ = numRows - 1;
        int rowLength = (int) Math.ceil((float) s.length() / lengthOffset) * listNumsInZ;
        char[][] charMatrix = new char[numRows][rowLength];
        boolean isBeginList = false;
        int x = 0;
        int y = 0;
        int charCursor = 0;
        char[] charArray = s.toCharArray();
        while (charCursor < s.length()) {
            charMatrix[y][x] = charArray[charCursor];
            charCursor++;
            if (y == 0) {
                isBeginList = true;
            }
            if (y == numRows - 1) {
                isBeginList = false;
            }
            if (isBeginList) {
                y++;
            } else {
                x++;
                y--;
            }
        }
        char[] newArray = new char[s.length()];
        int newCursor = 0;
        for (int yIndex = 0; yIndex < numRows; yIndex++) {
            for (int xIndex = 0; xIndex < rowLength; xIndex++) {
                if (charMatrix[yIndex][xIndex] != '\0') {
                    newArray[newCursor] = charMatrix[yIndex][xIndex];
                    newCursor++;
                }
            }
        }
        return new String(newArray);
    }
}
