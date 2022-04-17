package leetcode.dp;

/**
 * 63. 不同路径 II
 */
public class Solution_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0 || obstacleGrid[0][0] == 1) {
            return 0;
        }
        int rowNum = obstacleGrid.length, columnNum = obstacleGrid[0].length;
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        dp[0][0] = 1;
        for (int row = 1; row < rowNum; row++) {
            dp[row][0] = obstacleGrid[row][0] == 0 ? dp[row - 1][0] : 0;
        }
        for (int column = 1; column < columnNum; column++) {
            dp[0][column] = obstacleGrid[0][column] == 0 ? dp[0][column - 1] : 0;
        }
        for (int row = 1; row < rowNum; row++) {
            for (int column = 1; column < columnNum; column++) {
                if (obstacleGrid[row][column] == 1) {
                    continue;
                }
                dp[row][column] = dp[row - 1][column] + dp[row][column - 1];
            }
        }
        return dp[rowNum - 1][columnNum - 1];
    }
}