// 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。

// 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。

// 示例 1:

// 输入: [1, 2, 2, 3, 1]
// 输出: 2
// 解释: 
// 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
// 连续子数组里面拥有相同度的有如下所示:
// [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
// 最短连续子数组[2, 2]的长度为2，所以返回2.

// 示例 2:

// 输入: [1,2,2,3,1,4,2]
// 输出: 6

// 注意:
// nums.length 在1到50,000区间范围内。
// nums[i] 是一个在0到49,999范围内的整数。

// 3个哈希表 第一次出现和最后一次出现的索引

class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> first = new HashMap<>();
        HashMap<Integer, Integer> last = new HashMap<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(!first.containsKey(num)) first.put(num, i);
            last.put(num, i);
            count.put(num, count.getOrDefault(num, 0)+1);
        }
        int max_count = 0;
        for(int num : nums){
            max_count = Math.max(max_count, count.get(num));
        }
        int res = nums.length;
        for(int num : nums){
            if(count.get(num) == max_count){
                res = Math.min(res, last.get(num)-first.get(num)+1);
            }
        }
        return res;
    }
}
