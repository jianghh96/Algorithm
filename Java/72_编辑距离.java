// 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。

// 你可以对一个单词进行如下三种操作：

// 1.插入一个字符
// 2.删除一个字符
// 3.替换一个字符

// 示例 1：

// 输入：word1 = "horse", word2 = "ros"
// 输出：3
// 解释：
/ horse -> rorse (将 'h' 替换为 'r')
// rorse -> rose (删除 'r')
// rose -> ros (删除 'e')

// 动态规划

// dp[i][j] 代表 word1 到 i 位置转换成 word2 到 j 位置需要最少步数
// 当 word1[i] == word2[j]，dp[i][j] = dp[i-1][j-1]；
// 当 word1[i] != word2[j]，dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
// 其中，dp[i-1][j-1] 表示替换操作，dp[i-1][j] 表示删除操作，dp[i][j-1] 表示插入操作。
// 要考虑 m=0 或 n=0 的情况

class Solution {
    public int minDistance(String word1, String word2) {
        // 动态规划！！！
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];

        // 考虑 m=0 或 n=0 的情况
        for(int j = 0; j <= n; j++)
            dp[0][j] = j;
        for(int i = 1; i <= m; i++)
            dp[i][0] = i;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    // dp[i-1][j-1] 表示替换操作，dp[i-1][j] 表示删除操作，dp[i][j-1] 表示插入操作
                    // Math.min()只能有2个元素
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i][j-1]), dp[i-1][j]) + 1;
            }
        }
        
        return dp[m][n];
    }
}
