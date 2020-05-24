// 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。

// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。

// 示例 1:

// 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
// 输出: 2

class Solution {
    public int majorityElement(int[] nums) {
        int res = nums[0], count = 1;
        for(int i = 1; i < nums.length; i++){
            if(count == 0){
                res = nums[i];
                count++;
            }else{
                if(nums[i] == res)
                    count++;
                else
                    count--;
            }
        }
        return res;
    }
}
