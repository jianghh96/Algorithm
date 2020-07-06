// 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

// 注意:

// 每个数组中的元素不会超过 100
// 数组的大小不会超过 200
// 示例 1:

// 输入: [1, 5, 11, 5]

// 输出: true

// 解释: 数组可以分割成 [1, 5, 5] 和 [11].

// 解题思路：https://leetcode-cn.com/problems/partition-equal-subset-sum/solution/0-1-bei-bao-wen-ti-xiang-jie-zhen-dui-ben-ti-de-yo/

class Solution {
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        if(len == 0) return false;
        int sum = 0;
        for(int num : nums)
            sum += num;
        if(sum % 2 != 0) return false;
        int target = sum / 2;
        boolean[][] dp = new boolean[len][target+1];
        if(nums[0] <= target)
            dp[0][nums[0]] = true;
        for(int i = 1; i < len; i++){
            for(int j = 0; j <= target; j++){
                dp[i][j] = dp[i-1][j];
                if(nums[i] == j){
                    dp[i][j] = true;
                }
                if(nums[i] < j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[len-1][target];
    }
}
