// 统计一个数字在排序数组中出现的次数。

// 示例:

// 输入: nums = [5,7,7,8,8,10], target = 8
// 输出: 2

// 二分法

class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        int left, right;
        left = leftIndex(nums, target);
        right = rightIndex(nums, target);
        if(left == -1 && right == -1) return 0;
        return right-left+1;
    }

    public int leftIndex(int[] nums, int target){
        int left = 0, right = nums.length-1;
        int res = -1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(target > nums[mid]){
                left = mid + 1;
            }else{
                if(target == nums[mid]) res = mid;
                right = mid - 1;
            }
        }
        return res;
    }

    public int rightIndex(int[] nums, int target){
        int left = 0, right = nums.length-1;
        int res = -1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(target < nums[mid]){
                right = mid - 1;
            }else{
                if(target == nums[mid]) res = mid;
                left = mid + 1;
            }
        }
        return res;
    }
}
