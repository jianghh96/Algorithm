// 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。

// 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。

// 示例 2:

// 输入: 2
// 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]

class Solution {
    public double[] twoSum(int n) {
        int[][] dp = new int[n+1][6*n+1];
        double[] res = new double[5*n+1];
        double all = Math.pow(6, n);
        for(int i = 1; i <= 6; i++){
            dp[1][i] = 1;
        }
        for(int i = 1; i <= n; i++){
            for(int j = i; j <= 6*i; j++){
                for(int k = 1; k <= 6; k++){
                    dp[i][j] += j >= k ? dp[i-1][j-k] : 0;
                    if(i == n)
                        res[j-n] = dp[i][j]/all;
                }
            }
        }
        return res;
    }
}
