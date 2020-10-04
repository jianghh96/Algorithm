// 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

// 必须原地修改，只允许使用额外常数空间。

// 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
// 1,2,3 → 1,3,2
// 3,2,1 → 1,2,3
// 1,1,5 → 1,5,1

// 一边扫描思想：https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-by-leetcode/

// 时间复杂度：O(n)，空间复杂度：O(1)。

class Solution {
    public void nextPermutation(int[] nums) {
        //源于离散数学及其应用的算法：（以3 4 5 2 1 为例）
        //从后往前寻找第一次出现的正序对：（找到 4,5）
        //之后因为从5 开始都是逆序，所以把他们反转就是正序：3 4 1 2 5
        //之后4 的位置应该是：在它之后的，比他大的最小值（5）
        //交换这两个值：得到 3 5 1 2 4
        // 对于初始即为逆序的序列，将在反转步骤直接完成
        int len = nums.length;
        if(len < 2) return;
        int i = len-1;
        while(i > 0 && nums[i-1] >= nums[i]){
            i--;
        }
        reverse(nums, i, len-1);
        if(i == 0) return;
        int j = i-1;
        while(i < len && nums[j] >= nums[i]){
            i++;
        }
        swap(nums, i, j);
    }
    public void swap(int[] nums, int left, int right){
        int num = nums[left];
        nums[left] = nums[right];
        nums[right] = num;
    }
    public void reverse(int[] nums, int left, int right){
        while(left < right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
