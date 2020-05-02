// 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

// 示例:

// 输入: [0,1,0,3,12]
// 输出: [1,3,12,0,0]

// 说明:

// 必须在原数组上操作，不能拷贝额外的数组。
// 尽量减少操作次数。

// 解题思路：https://leetcode-cn.com/problems/move-zeroes/solution/dong-hua-yan-shi-283yi-dong-ling-by-wang_ni_ma/

// 方法：参考快排的思想，一次遍历

class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0)
            return;
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                // 要判断一下，可能会出现i==j的情况
                if(i > j){
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}
