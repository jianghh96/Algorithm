// 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

// 注意:
// 不能使用代码库中的排序函数来解决这道题。

// 示例:

// 输入: [2,0,2,1,1,0]
// 输出: [0,0,1,1,2,2]

class Solution {
    public void sortColors(int[] nums) {
        // 快排原地分区函数的思想
        // p0左边为0，p2右边为2，cur当前指针
        int p0 = 0;
        int p2 = nums.length - 1;
        int cur = 0;
        if(nums.length < 2) return;
        while(cur <= p2){
            if(nums[cur] == 0){
                swap(nums, p0, cur);
                p0 += 1;
                cur++;
            }else if(nums[cur] == 2){
                swap(nums, p2, cur);
                // 注意：仅是p2左移一位！
                p2 -= 1;
            }else{
                cur++;
            }
        }
    }

    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
