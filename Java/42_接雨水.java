// 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。

// 示例:
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
// 输出: 6

// 按列求 + 动态规划
// 按列求：求每列积水量；动态规划：分别求每列左右最高度

// https://leetcode-cn.com/problems/trapping-rain-water/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-8/

class Solution {
    public int trap(int[] height) {
        if(height.length == 0)
            return 0;
        int res = 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        // 左边最高是从最左边开始计算
        for(int i = 1; i < height.length; i++){
            left[i] = Math.max(left[i-1], height[i-1]);
        }
        // 右边最高是从最右边向左计算
        for(int j = height.length-2; j >= 0; j--){
            right[j] = Math.max(right[j+1], height[j+1]);
        }
        for(int i = 1; i < height.length-1; i++){
            int maxheight = Math.min(left[i], right[i]);
            if(maxheight > height[i])
                res += maxheight - height[i];
        }
        return res;
    }
}
