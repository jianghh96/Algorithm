// 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

// 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。

// 此外，你可以假设该网格的四条边均被水包围。

// 示例 2:

// 输入:
// 11000
// 11000
// 00100
// 00011
// 输出: 3
// 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。

// 解题思路：https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-shu-liang-by-leetcode/

// DFS
// 扫描整个二维网格。如果一个位置为 11，则以其为起始节点开始进行深度优先搜索。在深度优先搜索的过程中，每个搜索到的 1 都会被重新标记为 0。
// 最终岛屿的数量就是我们进行深度优先搜索的次数。

class Solution {
    public void dfs(char[][] grid, int row, int col){
        int rows = grid.length;
        int cols = grid[0].length;
        if(row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '0')
            return;
        grid[row][col] = '0';
        dfs(grid, row-1, col); 
        dfs(grid, row+1, col); 
        dfs(grid, row, col-1); 
        dfs(grid, row, col+1); 
    }

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int res = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == '1'){
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }
}


