package leetcode.dynamicplanning;

public class Solution_122 {
    public int maxProfit(int[] prices) {
        int profit =0;
        for(int i =1;i<prices.length;i++) {
            int tempPro = prices[i] - prices[i-1];
            profit+=tempPro>0?tempPro:0;
        }
        return profit;
    }
}
