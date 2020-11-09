// 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。

// '.' 匹配任意单个字符
// '*' 匹配零个或多个前面的那一个元素
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。

// 说明: s 可能为空，且只包含从 a-z 的小写字母。
//      p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。

// 方法 1：回溯
// 如果模式串中有星号，它会出现在第二个位置，即pattern[1]。这种情况下，我们可以直接忽略模式串中这一部分，或者删除匹配串的第一个字符，
// 前提是它能够匹配模式串当前位置字符，即pattern[0] 。如果两种操作中有任何一种使得剩下的字符串能匹配，那么初始时，匹配串和模式串就可以被匹配。

class Solution {
    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() &&
                               (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
        // isMatch(text.substring(1), pattern)，首字符匹配，pattern不动就可以！
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }
}


// 方法 2：动态规划

class Solution {
    public boolean isMatch(String s, String p) {
        int ls = s.length(), lp = p.length();
        boolean[][] dp = new boolean[ls+1][lp+1];
        dp[0][0] = true;
        for(int j = 2; j <= lp; j++){
            // 判断s为空，p非空
            if(p.charAt(j-1) == '*')
                dp[0][j] = dp[0][j-2];
        }
        for(int i = 1; i <= ls; i++){
            for(int j = 1; j <= lp; j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1) == '*'){
                    if(s.charAt(i-1) != p.charAt(j-2) && p.charAt(j-2) != '.')
                        dp[i][j] = dp[i][j-2];
                    else
                        dp[i][j] = dp[i][j-2] || dp[i][j-1] || dp[i-1][j];
                }                   
            }
        }
        return dp[ls][lp];
    }
}

