// 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

// 说明：本题中，我们将空字符串定义为有效的回文串。

// 示例 1:

// 输入: "A man, a plan, a canal: Panama"
// 输出: true

// 示例 2:

// 输入: "race a car"
// 输出: false

class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) return true;
        // 全部字符变为小写
        String s_low = s.toLowerCase();
        int left = 0, right = s.length()-1;
        // 只考虑字母和数字字符
        while(left < right){
            if(!((s_low.charAt(left) >= '0' && s_low.charAt(left) <= '9') || (s_low.charAt(left) >= 'a' && s_low.charAt(left) <= 'z'))){
                left++;
                continue;
            }
            if(!((s_low.charAt(right) >= '0' && s_low.charAt(right) <= '9') || (s_low.charAt(right) >= 'a' && s_low.charAt(right) <= 'z'))){
                right--;
                continue;
            }
            if(s_low.charAt(left) != s_low.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
