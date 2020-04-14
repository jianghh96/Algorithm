// 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

// 输入: "babad"
// 输出: "bab"
// 注意: "aba" 也是一个有效答案。

// 方法四：中心扩展算法
// 我们观察到回文中心的两侧互为镜像。因此，回文可以从它的中心展开，并且只有 2n−1 个这样的中心。
// 你可能会问，为什么会是 2n−1 个？原因在于所含字母数为偶数的回文的中心可以处于两字母之间（例如{“abba”}“abba” 的中心在两个{‘b’}‘b’ 之间）。

class Solution {
    public String longestPalindrome(String s) {
    // 要判断s.length() < 1，存在长度为0的字符串
    // 数组可写为nums.length，字符串写为s.length()
    if (s == null || s.length() < 1) return "";
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
        // 所含字母数为奇数
        int len1 = expandAroundCenter(s, i, i); 
        // 所含字母数为偶数
        int len2 = expandAroundCenter(s, i, i + 1);
        int len = Math.max(len1, len2);
        if (len > end - start) {
            start = i - (len - 1) / 2;
            end = i + len / 2;
        }
    }
    // 字符串子串写法：s.substring(start, end + 1)
    return s.substring(start, end + 1);
}

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        // 字符串某个位置字符s.charAt(L)
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
