// 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。

// 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。

// 示例:

// X X X X
// X O O X
// X X O X
// X O X X

// 运行你的函数后，矩阵变为：

// X X X X
// X X X X
// X X X X
// X O X X

// 解释:

// 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
// 如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。

// 思路：任何与边界上的'O'直接或间接相连的'O'都不会被填充'X'
// 先标记与边界上的'O'直接或间接相连的'O'，再遍历全矩阵进行填充，不要忘记把标记的还原成'O'

class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0)
            return;
        int m = board.length, n = board[0].length;
        // 搜索上下边界的'O'
        for(int j = 0; j < n; j++){
            if(board[0][j] == 'O')
                dfs(board, 0, j);
            if(board[m-1][j] == 'O')
                dfs(board, m-1, j);
        }
        // 搜索左右边界
        for(int i = 0; i < m; i++){
            if(board[i][0] == 'O')
                dfs(board, i, 0);
            if(board[i][n-1] == 'O')
                dfs(board, i, n-1);
        }
        // 标记完，再次遍历，现在矩阵中可能有3种字符，'X','M','O'
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'X')
                    continue;
                else if(board[i][j] == 'O')  // 没被标记的'O'，被填充
                    board[i][j] = 'X';   
                else                         // 被标记过的，恢复成'O'
                    board[i][j] = 'O';
            }
        }
    }
    public void dfs(char[][] board, int i, int j){
        int m = board.length, n = board[0].length;
        // 越界或者不是字符'O'终止
        if(i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O')
            return;
        board[i][j] = 'M';  // 修改为'M'表示这个字符被标记了
        // 搜索四个方向
        dfs(board, i-1, j);
        dfs(board, i+1, j);
        dfs(board, i, j-1);
        dfs(board, i, j+1);
    }
}
