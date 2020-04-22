// 给定一个非负整数数组，你最初位于数组的第一个位置。

// 数组中的每个元素代表你在该位置可以跳跃的最大长度。

// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。

// 假设你总是可以到达数组的最后一个位置。

// 示例:

// 输入: [2,3,1,1,4]
// 输出: 2
// 解释: 跳到最后一个位置的最小跳跃数是 2。从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。

// 贪心算法

// 注意边界end的使用！！！

class Solution {
    public int jump(int[] nums) {
        if(nums.length == 0 ||nums.length == 1) return 0;
        int end = 0;
        int max_dist = 0;
        int steps = 0;
        // 贪心算法
        for(int i = 0; i < nums.length-1; i++){
            //找能跳的最远的
            max_dist = Math.max(max_dist, i + nums[i]);
            //遇到边界，就更新边界，并且步数加一
            if(i == end){
                end = max_dist;
                steps++;
            }
        }
        return steps;
    }
}
