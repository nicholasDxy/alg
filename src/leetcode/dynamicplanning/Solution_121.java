package leetcode.dynamicplanning;

public class Solution_121 {

    public int maxProfit(int[] prices) {
        int lowestPriceLeft = prices[0];
        int maxPro = 0;
        for (int i = 1; i< prices.length;i++) {
            int tempPro = prices[i] - lowestPriceLeft;
            if (tempPro>maxPro) {
                maxPro = tempPro;
            }
            if (prices[i]<lowestPriceLeft) {
                lowestPriceLeft = prices[i];
            }
        }
        return maxPro;
    }
    public int maxProfit_long(int[] prices) {
        int[] maxRight = new int[prices.length];
        int max = 0;
        for (int i = prices.length-1;i>=0;i--) {
            if(prices[i]>max) {
                max = prices[i];
            }
            maxRight[i] = max;
        }
        int maxPro = 0;
        for (int i = 0; i<prices.length;i++) {
            int tempPro = maxRight[i] - prices[i];
            if (tempPro>maxPro) {
                maxPro = tempPro;
            }
        }
        return maxPro>0?maxPro:0;
    }
}
