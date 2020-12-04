// 找出数组中重复的数字。

//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

// 示例 ：

// 输入：
// [2, 3, 1, 0, 2, 5, 3]
// 输出：2 或 3 

// 哈希表

class Solution {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num))
                return num;
            set.add(num);
        }
        return -1;
    }
}

// 交换 O(1)空间

class Solution {
    public int findRepeatNumber(int[] nums) {
        int temp;
        for(int i = 0; i < nums.length; i++){
            while(i != nums[i]){
                if(nums[i] == nums[nums[i]]) // 判断重复
                    return nums[i];
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp; 
            }
        }
        return -1;
    }
}
