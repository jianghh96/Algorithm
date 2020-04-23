// 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

// 问总共有多少条不同的路径？

// 示例 1:

// 输入: m = 3, n = 2
// 输出: 3
// 解释:
// 从左上角开始，总共有 3 条路径可以到达右下角。
// 1. 向右 -> 向右 -> 向下
// 2. 向右 -> 向下 -> 向右
// 3. 向下 -> 向右 -> 向右

// 思路一：排列组合

C(m+n-2) (n-1)

// 动态规划

// 动态方程：dp[i][j] = dp[i-1][j] + dp[i][j-1]

// 时间复杂度：O(m * n)
// 空间复杂度：O(m * n)

// 注意 m=1 或 n=1 时，同行或同列只有1条路径！！！

class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0) return 0;
        // 动态规划
        int[][] dp = new int[m][n];
        for(int i = 0; i < n; i++)
            dp[0][i] = 1;
        for(int i = 0; i < m; i++)
            dp[i][0] = 1;
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }
}

// 优化：每次只需要 dp[i-1][j]，dp[i][j-1]

// 优化1：空间复杂度 O(2n)

class Solution {
    public int uniquePaths(int m, int n) {
        int[] pre = new int[n];
        int[] cur = new int[n];
        Arrays.fill(pre, 1);
        Arrays.fill(cur,1);
        // pre上一行，cur当前行
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n; j++){
                cur[j] = cur[j-1] + pre[j];
            }
            pre = cur.clone();
        }
        return pre[n-1]; 
    }
}

// 优化2：空间复杂度 O(n)

// 上一行pre其实就是当前行cur

class Solution {
    public int uniquePaths(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur,1);
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n; j++){
                cur[j] += cur[j-1] ;
            }
        }
        return cur[n-1];
    }
}


