// 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序
// 这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。

// 示例 1:

// 输入: [1,2,1]
// 输出: [2,-1,2]

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0) return nums;
        Stack<Integer> stack = new Stack<>();
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);
        for(int i = 0; i < 2 * len; i++){
            int num = nums[i % len];
            while(!stack.isEmpty() && num > nums[stack.peek()])
                res[stack.pop()] = num;
            if(i < len)
                stack.push(i);
        }
        return res;
    }
}
