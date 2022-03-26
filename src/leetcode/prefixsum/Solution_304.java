package leetcode.prefixsum;

/**
 * 304. 二维区域和检索 - 矩阵不可变
 */
public class Solution_304 {

    public static void main(String[] args) {
        int[][] nums = new int[1][2];
        nums[0] = new int[]{-4, -5};
        NumMatrix matrix = new NumMatrix(nums);
        System.out.println(matrix.sumRegion(0,0,0,1));
    }

    static class NumMatrix {
        int[][] prefix;

        public NumMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return;
            }
            prefix = new int[matrix.length + 1][matrix[0].length + 1];
            for (int i = 1; i < prefix.length; i++) {
                int lineSum = 0; //当前行的和
                for (int j = 1; j < prefix[0].length; j++) {
                    lineSum += matrix[i - 1][j - 1];
                    prefix[i][j] = lineSum + prefix[i - 1][j]; // 上一行的和加上当前行的合
                }
            }
            printPrefix();
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return prefix[row2 + 1][col2 + 1] - prefix[row1][col2 + 1] - prefix[row2 + 1][col1] + prefix[row1][col1];
        }

        public void printPrefix() {
            for (int i = 0; i < prefix.length; i++) {
                for (int j = 0; j < prefix[0].length; j++) {
                    System.out.print(prefix[i][j] + ",");
                }
                System.out.println();
            }
        }
    }
}
