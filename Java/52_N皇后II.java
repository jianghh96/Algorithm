// n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

// 给定一个整数 n，返回 n 皇后不同的解决方案的数量。

// 示例:

// 输入: 4

// 输出: 2

// 解释: 4 皇后问题存在如下两个不同的解法。

// [
// [".Q..",  // 解法 1
//   "...Q",
//   "Q...",
//   "..Q."],

//  ["..Q.",  // 解法 2
//   "Q...",
//   "...Q",
//   ".Q.."]
// ]
 
// 提示：

// 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。
// 当然，她横、竖、斜都可走一或 N-1 步，可进可退。

class Solution {
    private int res = 0; // 需用全局变量
    public int totalNQueens(int n) {
        if(n <= 0) return 0;
        char[][] c = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                c[i][j] = '.';
            }
        }
        backtracking(c, 0);
        return res;
    }
    public void backtracking(char[][] c, int row){
        if(row == c.length){
            res++;
            return;
        }
        for(int j = 0; j < c[0].length; j++){
            if(checkNQueens(c, row, j)){
                c[row][j] = 'Q';
                backtracking(c, row+1);
                c[row][j] = '.';
            }
        }
    }
    public boolean checkNQueens(char[][] c, int row, int col){
        for(int i = 0; i < row; i++){
            if(c[i][col] == 'Q')
                return false;
        }
        for(int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--){
            if(c[i][j] == 'Q')
                return false;
        }
        for(int i = row-1, j = col+1; i >= 0 && j < c[0].length; i--, j++){
            if(c[i][j] == 'Q')
                return false;
        }
        return true;
    }
}
