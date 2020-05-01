// 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。

// 示例:

// 输入: [1,2,3,4]
// 输出: [24,12,8,6]

// 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。

// 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。

// 乘积 = 当前数左边的乘积 * 当前数右边的乘积

// 时间复杂度：O(N)，空间复杂度：O(N)

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int[] res = new int[len];
        if(len == 0) return res;
        left[0] = 1;
        for(int i = 1; i < len; i++){
            left[i] = left[i-1] * nums[i-1];
        }
        right[len-1] = 1;
        for(int i = len-2; i >= 0; i--){
            right[i] = right[i+1] * nums[i+1];
        }
        for(int i = 0; i < len; i++){
            res[i] = left[i] * right[i];
        }
        return res;
    }
}

// 时间复杂度：O(N)，空间复杂度：O(1)

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int k = 1;
        for(int i = 0; i < res.length; i++){
            res[i] = k;
            k = k * nums[i]; // 此时数组存储的是除去当前元素左边的元素乘积
        }
        k = 1;
        for(int i = res.length - 1; i >= 0; i--){
            res[i] *= k; // k为该数右边的乘积。
            k *= nums[i]; // 此时数组等于左边的 * 该数右边的。
        }
        return res;
    }
}
