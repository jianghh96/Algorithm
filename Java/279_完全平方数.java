// 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

// 输入: n = 13
// 输出: 2
// 解释: 13 = 4 + 9.

// 对数组进行遍历，下标为i，每次都将当前数字先更新为最大的结果，即dp[i]=i，比如i=4，最坏结果为4=1+1+1+1即为4个数字
// 动态转移方程为：dp[i] = MIN(dp[i], dp[i - j * j] + 1)，i表示当前数字，j*j表示平方数
// 时间复杂度：O(n*sqrt(n))

class Solution {
    public int numSquares(int n) {
        // 默认初始化值都为0
        int[] dp = new int[n+1];
        for(int i = 1; i <= n; i++){
            // 最坏的情况就是每次+1
            dp[i] = i;
            for(int j = 1; i - j * j >= 0; j++){
                // 动态转移方程
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
