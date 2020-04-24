// 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

// 求在该柱状图中，能够勾勒出来的矩形的最大面积。

// https://leetcode-cn.com/problems/largest-rectangle-in-histogram/

// 示例:

// 输入: [2,1,5,6,2,3]
// 输出: 10

// 解法思想：https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/zhu-zhuang-tu-zhong-zui-da-de-ju-xing-by-leetcode/

// 方法1：优化暴力
// 时间复杂度：O(n^2)，空间复杂度：O(1)

public class Solution {
   public int largestRectangleArea(int[] heights) {
       int maxarea = 0;
       for (int i = 0; i < heights.length; i++) {
           int minheight = Integer.MAX_VALUE;
           for (int j = i; j < heights.length; j++) {
               minheight = Math.min(minheight, heights[j]);
               maxarea = Math.max(maxarea, minheight * (j - i + 1));
           }
       }
       return maxarea;
   }
}


// 方法2：分治思想
// 时间复杂度：平均开销：O(nlogn)，最坏情况：O(n^2)
// 空间复杂度：O(n)

public class Solution {
    public int calculateArea(int[] heights, int start, int end) {
        if (start > end)
            return 0;
        int minindex = start;
        for (int i = start; i <= end; i++)
            if (heights[minindex] > heights[i])
                minindex = i;
        return Math.max(heights[minindex] * (end - start + 1), Math.max(calculateArea(heights, start, minindex - 1), calculateArea(heights, minindex + 1, end)));
    }
    public int largestRectangleArea(int[] heights) {
        return calculateArea(heights, 0, heights.length - 1);
    }
}


// 方法3：栈
// 时间复杂度：O(n)
// 空间复杂度：O(n)

public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack < Integer > stack = new Stack < > ();
        stack.push(-1);
        int maxarea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
            stack.push(i);
        }
        while (stack.peek() != -1)
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() -1));
        return maxarea;
    }
}
