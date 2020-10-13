// 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字）。

// 示例 1:

// 输入: [2,3,-2,4]
// 输出: 6
// 解释: 子数组 [2,3] 有最大乘积 6。

// 动态规划

class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 0) return 0;
        int max = nums[0];
        // curMax 表示以第 i 个元素的结尾的子数组，乘积最大的值
        int preMax = nums[0];
        int preMin = nums[0];
        for(int i = 1; i < nums.length; i++){
            int curMax = Math.max(Math.max(preMax * nums[i], preMin * nums[i]), nums[i]);
            int curMin = Math.min(Math.min(preMax * nums[i], preMin * nums[i]), nums[i]);
            max = Math.max(max, curMax);
            // 注意这样更新
            preMax = curMax;
            preMin = curMin;
        }
        return max;
    }
}

class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int res = nums[0], max = nums[0], min = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < 0){
                int tmp = max;
                max = min;
                min = tmp;
            }
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);
            res = Math.max(res, max);
        }
        return res;
    }
}
