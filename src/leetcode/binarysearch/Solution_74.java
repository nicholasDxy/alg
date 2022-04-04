package leetcode.binarysearch;

/**
 * 74. 搜索二维矩阵
 */
public class Solution_74 {
    public static void main(String[] args) {
        System.out.println(new Solution_74().searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}},13));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        return binarySearch(matrix, target);
    }

    private boolean binarySearch(int[][] matrix, int target) {
        int rowLength = matrix.length, columnLength = matrix[0].length;
        int startRow = 0, endRow = matrix.length - 1;
        //二分法找到行
        while (startRow <= endRow) {
            if (startRow == endRow) {
                break;
            }
            int midRow = startRow + endRow >> 1;
            if (matrix[midRow][columnLength - 1] < target) {
                startRow = midRow + 1;
            } else {
                endRow = midRow;
            }
        }
        //在行中找目标值
        int startColumn = 0, endColumn = columnLength - 1;
        while (startColumn <= endColumn) {
            if (startColumn == endColumn) {
                break;
            }
            int midColumn = startColumn + endColumn >> 1;
            if (matrix[startRow][midColumn] < target) {
                startColumn = midColumn + 1;
            } else {
                endColumn = midColumn;
            }
        }
        return matrix[startRow][startColumn] == target;
    }
}
