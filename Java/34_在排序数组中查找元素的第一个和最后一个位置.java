// 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

// 你的算法时间复杂度必须是 O(log n) 级别。

// 如果数组中不存在目标值，返回 [-1, -1]。

// 输入: nums = [5,7,7,8,8,10], target = 8
// 输出: [3,4]

// O(log n)必须想到二分法！

// https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/er-fen-cha-zhao-zhao-zuo-you-bian-jie-by-reedfan/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0)
            return new int[]{-1,-1};
        return new int[]{leftIndex(nums, target), rightIndex(nums, target)};
    }

    public int leftIndex(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int res = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }else{
                if(nums[mid] == target)
                    res = mid;
                right = mid - 1;
            }
        }
        return res;
    }

    public int rightIndex(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int res = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > target){
                right = mid - 1;
            }else{
                if(nums[mid] == target)
                    res = mid;
                left = mid + 1;
            }
        }
        return res;
    }
}
