// 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。

// 示例:

// 输入: n = 10
// 输出: 12
// 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。

// 说明:  
// 1 是丑数。
// n 不超过1690。

// 解题思路：https://leetcode-cn.com/problems/chou-shu-lcof/solution/mian-shi-ti-49-chou-shu-dong-tai-gui-hua-qing-xi-t/

class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int idx2 = 0, idx3 = 0, idx5 = 0;
        for(int i = 1; i < n; i++){
            int n2 = dp[idx2] * 2, n3 = dp[idx3] * 3, n5 = dp[idx5] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            // 注意这里！！！
            if(dp[i] == n2) idx2++;
            if(dp[i] == n3) idx3++;
            if(dp[i] == n5) idx5++;
        }
        return dp[n-1];
    }
}
