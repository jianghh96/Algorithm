// 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。

// 要求时间复杂度为O(n)。

// 示例1:

// 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
// 输出: 6
// 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        int curMax = nums[0], max = nums[0];
        for(int i = 1; i < len; i++){
            curMax = Math.max(curMax + nums[i], nums[i]);
            max = Math.max(curMax, max);
        }
        return max;
    }
}
