// 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
// 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。

// 示例:
// 输入: [0,1,2,3,4,5,6,7,9]
// 输出: 8

// 解题思路：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/solution/mian-shi-ti-53-ii-0n-1zhong-que-shi-de-shu-zi-er-f/

class Solution {
    public int missingNumber(int[] nums) {
        // 左子数组：nums[i] = i;
        // 右子数组：nums[i] != i;
        int left = 0, right = nums.length - 1;
        while(left <= right){
            // 二分法
            int mid = left + (right-left) / 2;
            if(nums[mid] == mid)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }
}
