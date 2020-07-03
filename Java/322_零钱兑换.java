// 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

// 示例 1:

// 输入: coins = [1, 2, 5], amount = 11
// 输出: 3 
// 解释: 11 = 5 + 5 + 1

// 解题思路：https://leetcode-cn.com/problems/coin-change/solution/322-ling-qian-dui-huan-by-leetcode-solution/

// 动态规划-自上而下

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount < 1) return 0;
        return coinCount(coins, amount, new int[amount]);
    }
    private int coinCount(int[] coins, int amount, int[] count){
        if(amount < 0) return -1;
        if(amount == 0) return 0;
        if(count[amount-1] != 0) return count[amount-1];
        int min = Integer.MAX_VALUE;
        for(int coin : coins){
            int res = coinCount(coins, amount - coin, count);
            if(res >= 0 && res < min)
                min = res + 1;
        }
        if(min == Integer.MAX_VALUE)
            count[amount-1] = -1;
        else
            count[amount-1] = min;
        return count[amount-1];
    }
}

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
