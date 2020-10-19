// 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。

// 示例 1:

// 输入: "aba"
// 输出: True

// 示例 2:

// 输入: "abca"
// 输出: True
// 解释: 你可以删除c字符。

// 注意:
// 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。

class Solution {
    public boolean validPalindrome(String s) {
        if(s == null || s.length() < 3) return true;
        int left = 0, right = s.length()-1;
        while(left <= right){
            if(s.charAt(left) != s.charAt(right))
                return helper(s.substring(left+1, right+1)) || helper(s.substring(left, right));
            left++;
            right--;
        }
        return true;
    }
    private boolean helper(String s){
        if(s == null || s.length() < 2) return true;
        int left = 0, right = s.length()-1;
        while(left <= right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
