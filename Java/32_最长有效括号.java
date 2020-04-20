// 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

// 输入: ")()())"
// 输出: 4
// 解释: 最长有效括号子串为 "()()"

// 方法1：栈
// https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zhan-he-dong-tai-gui-hua-liang-chong-jie-fa-by-ree/

class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() < 2)
            return 0;
        int maxres = 0;
        Stack<Integer> stack = new Stack<>();
        // 连续有效括号，弹出后栈不为空
        stack.push(-1);
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.empty()){
                    stack.push(i);
                }else{
                // stack.peek()返回栈顶元素
                    maxres = Math.max(maxres, i - stack.peek());
                }
            }
        }
        return maxres;
    }
}


// 方法2：动态规划
// https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode/
