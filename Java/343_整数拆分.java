// 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。

// 示例 1:

// 输入: 2
// 输出: 1
// 解释: 2 = 1 + 1, 1 × 1 = 1。

// 示例 2:

// 输入: 10
// 输出: 36
// 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。

// 说明: 你可以假设 n 不小于 2 且不大于 58。

// 思路：https://leetcode-cn.com/problems/integer-break/solution/bao-li-sou-suo-ji-yi-hua-sou-suo-dong-tai-gui-hua-/

// 很容易得到一个递归表达式：
// F(n) = max{i ∗ F(n−i)}，i = 1，2，...，n−1

// 如果n - i比F(n - i)要大，显然就不用再继续分解了。故我们还需要比较i * (n - i)与i * F(n - i)的大小关系。
// 所以完整的表达式应该为：
// F(n) = max{i ∗ F(n−i), i ∗ (n−i)}, i=1,2,...,n−1

class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= i-1; j++){
                dp[i] = Math.max(dp[i], Math.max(j * dp[i-j], j * (i-j)));
            }
        }
        return dp[n];
    }
}
