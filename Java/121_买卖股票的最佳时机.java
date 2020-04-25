// 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

// 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。

// 注意：你不能在买入股票前卖出股票。

// 示例 :

// 输入: [7,1,5,3,6,4]
// 输出: 5
// 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。

// 方法1：暴力法

class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        for(int i = 0; i < prices.length-1; i++){
            for(int j = i+1; j < prices.length; j++){
                if(prices[j] > prices[i])
                    res = Math.max(prices[j] - prices[i], res);
            }
        } 
        return res;  
    }
}

// 方法2：在第i天卖出股票，买入股票价格为历史最低价格，可获得最大利润

class Solution {
    public int maxProfit(int[] prices) {
        // 历史最低价格
        int minPrice = Integer.MAX_VALUE;
        int res = 0;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < minPrice)
                minPrice = prices[i];
            res = Math.max(res, prices[i] - minPrice);
        }
        return res;
    }
}
