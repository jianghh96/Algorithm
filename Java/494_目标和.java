// 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。

// 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。

// 示例：

// 输入：nums: [1, 1, 1, 1, 1], S: 3
// 输出：5

// 解释：

// -1+1+1+1+1 = 3
// +1-1+1+1+1 = 3
// +1+1-1+1+1 = 3
// +1+1+1-1+1 = 3
// +1+1+1+1-1 = 3

// 一共有5种方法让最终目标和为3。
 
// 提示：

// 数组非空，且长度不会超过 20 。
// 初始的数组的和不会超过 1000 。
// 保证返回的最终结果能被 32 位整数存下。

// 动态规划

class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int sum = 0;
        for(int num : nums)
            sum += num;
        // sum(P) + sum(N) + sum(P) - sum(N) = S + sum(P) + sum(N)
        // 2 * sum(P) = S + sum   P 正，N 负
        if(sum < S || (sum + S) % 2 != 0) return 0;
        int target = (sum + S) / 2;
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int num : nums){
            for(int i = target; i >= num; i--)
                dp[i] = dp[i] + dp[i-num];
        }
        return dp[target];
    }
}

// DFS

public int findTargetSumWays(int[] nums, int S) {
    return findTargetSumWays(nums, 0, S);
}

private int findTargetSumWays(int[] nums, int start, int S) {
    if (start == nums.length) {
        return S == 0 ? 1 : 0;
    }
    return findTargetSumWays(nums, start + 1, S + nums[start])
            + findTargetSumWays(nums, start + 1, S - nums[start]);
}
