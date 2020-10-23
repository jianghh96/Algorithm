// 一条包含字母 A-Z 的消息通过以下方式进行了编码：

// 'A' -> 1
// 'B' -> 2
// ...
// 'Z' -> 26
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。

// 题目数据保证答案肯定是一个 32 位的整数。

// 示例 1：

// 输入："12"
// 输出：2
// 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。

// 示例 2：

// 输入："226"
// 输出：3
// 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。

// 示例 3：

// 输入：s = "0"
// 输出：0

// 思路：https://leetcode-cn.com/problems/decode-ways/solution/dong-tai-gui-hua-java-python-by-liweiwei1419/

class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        int len = s.length();
        int[] dp = new int[len+1];
        dp[0] = 1;
        if(s.charAt(0) == '0') return 0;
        dp[1] = 1;
        for(int i = 2; i <= len; i++){
            if(s.charAt(i-1) != '0')
                dp[i] += dp[i-1];
            //int two = Integer.valueOf(s.substring(i-2, i));
            int two = 10 * (s.charAt(i-2) - '0') + (s.charAt(i-1) - '0'); // 更快
            if(two >= 10 && two <= 26)
                dp[i] += dp[i-2];
        }
        return dp[len];
    }
}
