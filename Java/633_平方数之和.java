// 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。

// 示例 1：

// 输入：c = 5
// 输出：true
// 解释：1 * 1 + 2 * 2 = 5

// 示例 2：

// 输入：c = 3
// 输出：false

// 示例 3：

// 输入：c = 4
// 输出：true

class Solution {
    public boolean judgeSquareSum(int c) {
        if(c < 0) return false;
        int left = 0, right = (int) Math.sqrt(c);
        while(left <= right){
            int sum = left * left + right * right;
            if(sum < c)
                left++;
            else if(sum > c)
                right--;
            else
                return true;
        }
        return false;
    }
}
