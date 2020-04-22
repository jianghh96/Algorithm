// 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

// 示例:
// 输入: [-2,1,-3,4,-1,2,1,-5,4],
// 输出: 6
// 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

// 注意：Java不能直接对数组求最大值。

// 贪心算法

class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) return 0;
        int n = nums.length;
        // 贪心算法
        // 当前元素位置的最大和，迄今为止的最大和！！！
        int curSum = nums[0], maxSum = nums[0];
        for(int i = 1; i < n; i++){
            curSum = Math.max(curSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }
}
