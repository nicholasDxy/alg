package leetcode.dp;

/**
 * 746. 使用最小花费爬楼梯
 */
public class Solution_746 {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }
        return Math.min(dp[cost.length - 2] + cost[cost.length - 2], dp[cost.length - 1] + cost[cost.length - 1]);
    }

}
