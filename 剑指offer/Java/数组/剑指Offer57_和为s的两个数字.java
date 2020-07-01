// 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。

// 示例 1：

// 输入：nums = [2,7,11,15], target = 9
// 输出：[2,7] 或者 [7,2]

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while(left < right){
            if(nums[left] + nums[right] < target)
                left++;
            else if(nums[left] + nums[right] > target)
                right--;
            else
                return new int[]{nums[left], nums[right]};
        }
        return new int[0];
    }
}
