// 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。

// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。

// 示例 :

// 输入: "aaa"
// 输出: 6
// 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".

// 方法1：暴力

class Solution {
    public int countSubstrings(String s) {
        if(s == null || s.length() == 0) return 0;
        int len = s.length(), res = 0;
        for(int i = 0; i < len; i++){
            for(int j = i; j < len; j++){
                if(isSubstring(s.substring(i,j+1)))
                    res++;
            }
        }
        return res;
    }

    public boolean isSubstring(String s){
        int len = s.length();
        int left = 0, right = len-1;
        while(left <= right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}

// 方法二：中心扩散 和第5题思路一样
// 解题思路：https://leetcode-cn.com/problems/palindromic-substrings/solution/hui-wen-zi-chuan-zhi-647-hui-wen-zi-chuan-medium-l/

class Solution {
    public int countSubstrings(String s) {
        if(s == null || s.length() == 0) return 0;
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            // 以i为中心
            res += zhongxinkuosan(s, i, i);
            // 以i和i+1中间为中心
            res += zhongxinkuosan(s, i, i+1);
        }
        return res;
    }

    private int zhongxinkuosan(String s, int start, int end){
        int len = s.length(), count = 0;
        while(start >= 0 && end < len && s.charAt(start) == s.charAt(end)){
            count++;
            start--;
            end++;
        }
        return count;
    }
}
