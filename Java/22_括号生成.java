// 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

// 输入：n = 3
// 输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]

// 题解：https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/

// 方法1：动态规划

// 定义状态 dp[i]：使用 i 对括号能够生成的组合。
// dp[i] = "(" + dp[j] + ")" + dp[i- j - 1] , j = 0, 1, ..., i - 1

class Solution {
    // 把结果集保存在动态规划的数组里
    public List<String> generateParenthesis(int n) {
        if(n == 0) 
            return new ArrayList<>();
        
        // 这里 dp 数组我们把它变成列表的样子，方便调用
        List<List<String>> dp = new ArrayList<>();
        List<String> dp0 = new ArrayList<>();
        dp0.add("");
        dp.add(dp0);

        for(int i = 1; i <= n; i++){
            List<String> cur = new ArrayList<>();
            for(int j = 0; j <= i-1; j++){
                List<String> str1 = dp.get(j);
                List<String> str2 = dp.get(i-1-j);
                for(String s1 : str1){
                    for(String s2 : str2){
                        cur.add("(" + s1 + ")" + s2);
                    }
                }
            }
            dp.add(cur);
        }        
        return dp.get(n);
    }
}

// 方法2：深度优先遍历

class Solution {
    // 做减法

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        // 特判
        if (n == 0) {
            return res;
        }

        // 执行深度优先遍历，搜索可能的结果
        dfs("", n, n, res);
        return res;
    }

    /**
     * @param curStr 当前递归得到的结果
     * @param left   左括号还有几个可以使用
     * @param right  右括号还有几个可以使用
     * @param res    结果集
     */
    private void dfs(String curStr, int left, int right, List<String> res) {
        // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
        // 在递归终止的时候，直接把它添加到结果集即可，注意与「力扣」第 46 题、第 39 题区分
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }

        // 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
        if (left > right) {
            return;
        }

        if (left > 0) {
            dfs(curStr + "(", left - 1, right, res);
        }

        if (right > 0) {
            dfs(curStr + ")", left, right - 1, res);
        }
    }
}
