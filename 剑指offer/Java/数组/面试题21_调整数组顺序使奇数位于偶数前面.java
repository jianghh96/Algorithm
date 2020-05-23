// 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。

// 示例：

// 输入：nums = [1,2,3,4]
// 输出：[1,3,2,4] 
// 注：[3,1,2,4] 也是正确的答案之一。

// 暴力

class Solution {
    public int[] exchange(int[] nums) {
        if(nums == null || nums.length == 0) return nums;
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 == 0)
                arr2.add(nums[i]);
            else
                arr1.add(nums[i]);
        }
        int[] res = new int[nums.length];
        for(int i = 0; i < arr1.size(); i++){
            res[i] = arr1.get(i);
        }
        for(int i = 0; i < arr2.size(); i++){
            res[arr1.size()+i] = arr2.get(i);
        }
        return res;
    }
}

// 双指针

// 考虑定义双指针 i , j 分列数组左右两端，循环执行：
// 指针 i 从左向右寻找偶数；
// 指针 j 从右向左寻找奇数；
// 将 偶数 nums[i] 和 奇数 nums[j] 交换。
// 可始终保证： 指针 i 左边都是奇数，指针 j 右边都是偶数

class Solution {
    public int[] exchange(int[] nums) {
        if(nums == null || nums.length == 0) return nums;
        int left = 0, right = nums.length-1, tmp;
        while(left < right){
            while(left < right && nums[left] % 2 == 1)
                left++;
            while(left < right && nums[right] % 2 == 0)
                right--;
            tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
        return nums;
    }
}
