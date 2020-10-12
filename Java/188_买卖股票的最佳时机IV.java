// 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。

// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。

// 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

// 示例 1:

// 输入: [2,4,1], k = 2
// 输出: 2
// 解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。

// 示例 2:

// 输入: [3,2,6,5,0,3], k = 2
// 输出: 7
// 解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
//       随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。

class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length < 2 || k < 1) return 0;
        int len = prices.length;
        if(k >= len/2){
            int[][] dp = new int[len][2];
            dp[0][1] = -prices[0];
            for(int i = 1; i < len; i++){
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
                dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);
            }
            return dp[len-1][0];
        }
        // 交易行为：发生交易的标志是在某一天有了一次购买股票的行为，视为发生一次交易。
        // 发生一次抛售股票的行为，认为和上一次购买股票在一次交易行为内。
        int[][] dp = new int[k][2];
        for(int i = 0; i < k; i++)
            dp[i][1] = Integer.MIN_VALUE;
        for(int price : prices){
            for(int j = 0; j < k; j++){
                if(j == 0)
                    dp[0][1] = Math.max(dp[0][1], -price);
                else
                    dp[j][1] = Math.max(dp[j][1], dp[j-1][0]-price);
                dp[j][0] = Math.max(dp[j][0], dp[j][1]+price);
            }
        }
        return dp[k-1][0];
    }
}
