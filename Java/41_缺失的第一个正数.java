// 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。

// 示例 1:
// 输入: [1,2,0]
// 输出: 3

// 示例 2:
// 输入: [3,4,-1,1]
// 输出: 2

// 示例 3:
// 输入: [7,8,9,11,12]
// 输出: 1

// 解题思路：https://leetcode-cn.com/problems/first-missing-positive/solution/tong-pai-xu-python-dai-ma-by-liweiwei1419/

class Solution {
    public int firstMissingPositive(int[] nums) {
        // 交换思想
        int n = nums.length;
        for(int i = 0; i < n; i++){
            while(nums[i] >= 1 && nums[i] <= n && nums[nums[i]-1] != nums[i]){
                swap(nums, i, nums[i]-1);
            }
        }
        for(int i = 0; i < n; i++){
            if(nums[i]-1 != i)
                return i+1;
        }
        return n+1;
    }
    public void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
