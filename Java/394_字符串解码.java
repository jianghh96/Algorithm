// 给定一个经过编码的字符串，返回它解码后的字符串。

// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。

// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。

// 示例 ：

// 输入：s = "3[a2[c]]"
// 输出："accaccacc"

// 解题思路：https://leetcode-cn.com/problems/decode-string/solution/decode-string-fu-zhu-zhan-fa-di-gui-fa-by-jyd/

class Solution {
    public String decodeString(String s) {
        if(s == null) return s;
        StringBuilder res = new StringBuilder();
        int multi = 0;
        Stack<String> stack_res = new Stack<>();
        Stack<Integer> stack_multi = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '['){
                stack_multi.push(multi);
                stack_res.push(res.toString());
                multi = 0;
                res = new StringBuilder();
            }else if(c == ']'){
                StringBuilder tmp = new StringBuilder();
                int num = stack_multi.pop();
                for(int i = 0; i < num; i++)
                    tmp.append(res);
                res = new StringBuilder(stack_res.pop() + tmp);
            }else if(c >= '0' && c <= '9'){
                multi = multi * 10 + Integer.parseInt(c + "");
            }else{
                res.append(c);
            }
        }
        return res.toString();
    }
}
