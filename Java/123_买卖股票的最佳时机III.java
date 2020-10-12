// 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。

// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。

// 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

// 示例 1:

// 输入: [3,3,5,0,0,3,1,4]
// 输出: 6
// 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
//       随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。

// 示例 2:

// 输入: [1,2,3,4,5]
// 输出: 4
// 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。   
//       注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。   
//       因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。

// 解题思路：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/mai-mai-gu-piao-zui-jia-shi-ji-iiidong-tai-gui-hua/

// 动态规划

class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        int[][] dp = new int[prices.length][5];
        // 0:未交易，1:买入一次，2:卖出1次，3:买入2次，4:卖出2次
        // 实际状态依赖与上一状态，以下情况实际不存
        dp[0][1] = -prices[0];
        dp[0][3] = -prices[0];
        for(int i = 1; i < prices.length; i++){
            dp[i][0] = dp[i-1][0];
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);
            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1]+prices[i]);
            dp[i][3] = Math.max(dp[i-1][3], dp[i-1][2]-prices[i]);
            dp[i][4] = Math.max(dp[i-1][4], dp[i-1][3]+prices[i]);
        }
        return Math.max(dp[prices.length-1][2], dp[prices.length-1][4]);
    }
}

// 贪心算法

public int maxProfit(int[] prices) {
    int firstBuy = Integer.MIN_VALUE, firstSell = 0;
    int secondBuy = Integer.MIN_VALUE, secondSell = 0;
    for (int curPrice : prices) {
        if (firstBuy < -curPrice) {
            firstBuy = -curPrice;
        }
        if (firstSell < firstBuy + curPrice) {
            firstSell = firstBuy + curPrice;
        }
        if (secondBuy < firstSell - curPrice) {
            secondBuy = firstSell - curPrice;
        }
        if (secondSell < secondBuy + curPrice) {
            secondSell = secondBuy + curPrice;
        }
    }
    return secondSell;
}
