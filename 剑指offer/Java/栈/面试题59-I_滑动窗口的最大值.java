// 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。

// 示例:

// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
// 输出: [3,3,5,5,6,7] 
// 解释: 

//   滑动窗口的位置                最大值
// ---------------               -----
// [1  3  -1] -3  5  3  6  7       3
//  1 [3  -1  -3] 5  3  6  7       3
//  1  3 [-1  -3  5] 3  6  7       5
//  1  3  -1 [-3  5  3] 6  7       5
//  1  3  -1  -3 [5  3  6] 7       6
//  1  3  -1  -3  5 [3  6  7]      7

// 双端队列

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length < 2 || k == 1) return nums;
        // 双端队列，对应数组元素从大到小排列
        LinkedList<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length-k+1];
        for(int i = 0; i < nums.length; i++){
            while(!queue.isEmpty() && nums[i] > nums[queue.peekLast()]){
                queue.pollLast();
            }
            queue.addLast(i);
            if(queue.peek() < i-k+1)
                queue.poll();
            if(i-k+1 >= 0)
                res[i-k+1] = nums[queue.peek()];
        }
        return res;
    }
}
