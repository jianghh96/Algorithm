// 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

// 说明：每次只能向下或者向右移动一步。

class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                // 每次只能向下或者向右移动一步，即上一步只能从上面或左边来，考虑上边界和左边界
                if(i == 0 && j == 0)
                    continue;
                else if(i == 0)
                    grid[i][j] += grid[i][j-1];
                else if(j == 0)
                    grid[i][j] += grid[i-1][j];
                else
                    grid[i][j] += Math.min(grid[i][j-1], grid[i-1][j]);
            }
        }
        return grid[m-1][n-1];
    }
}
