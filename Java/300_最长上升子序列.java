// 给定一个无序的整数数组，找到其中最长上升子序列的长度。

// 示例:

// 输入: [10,9,2,5,3,7,101,18]
// 输出: 4 
// 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。

// 说明:
// 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
// 你算法的时间复杂度应该为 O(n2) 。

// 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?

// 解题思路：https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-by-leetcode-soluti/

// 动态规划

class Solution {
    public int lengthOfLIS(int[] nums) {
        // 动态规划
        if(nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int maxval = 1;
        dp[0] = 1;
        for(int i = 1; i < nums.length; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
            maxval = Math.max(maxval, dp[i]);
        }
        return maxval;
    }
}
