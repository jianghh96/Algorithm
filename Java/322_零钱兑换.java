// 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

// 示例 1:

// 输入: coins = [1, 2, 5], amount = 11
// 输出: 3 
// 解释: 11 = 5 + 5 + 1

// 解题思路：https://leetcode-cn.com/problems/coin-change/solution/dong-tai-gui-hua-shi-yong-wan-quan-bei-bao-wen-ti-/

// 动态规划：自下而上

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount < 0) return -1;
        if(amount == 0) return 0;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            for(int coin : coins){
                if(i-coin >= 0)
                    dp[i] = Math.min(dp[i], dp[i-coin]+1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}

// 完全背包问题

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0 || amount < 1) return 0;
        int[] dp = new int[amount+1];
        // 因为硬币可以重复使用，因此这是一个完全背包问题
        // 完全背包只需要将 0-1 背包的逆序遍历 dp 数组改为正序遍历即可
        for(int coin : coins){
            for(int i = coin; i <= amount; i++){
                if(i == coin)
                    dp[i] = 1;
                else if(dp[i] == 0 && dp[i-coin] != 0)
                    dp[i] = dp[i-coin]+1;
                else if(dp[i-coin] != 0)
                    dp[i] = Math.min(dp[i], dp[i-coin]+1);
            }
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }
}
