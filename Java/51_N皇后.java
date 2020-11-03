// n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。

// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

// 示例：

// 输入：4

// 输出：[
//  [".Q..",  // 解法 1
//   "...Q",
//   "Q...",
//   "..Q."],

//  ["..Q.",  // 解法 2
//   "Q...",
//   "...Q",
//   ".Q.."]
// ]

// 解释: 4 皇后问题存在两个不同的解法。
 
// 提示：

// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if(n <= 0) return res;
        char[][] c = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                c[i][j] = '.';
            }
        }
        backtracking(res, c, 0);
        return res;
    }
    public void backtracking(List<List<String>> res, char[][] c, int row){
        if(row == c.length){
            res.add(cToList(c));
            return;
        }
        for(int j = 0; j < c[0].length; j++){
            if(checkNQueens(c, row, j)){
                c[row][j] = 'Q';
                backtracking(res, c, row+1);
                c[row][j] = '.';
            }
        }
    }
    public boolean checkNQueens(char[][] c, int row, int col){
        for(int i = 0; i < row; i++){
            if(c[i][col] == 'Q')  // 检查同列
                return false;
        }
        for(int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--){
            if(c[i][j] == 'Q')  // 检查左上角
                return false;
        }
        for(int i = row-1, j = col+1; i >= 0 && j < c[0].length; i--, j++){
            if(c[i][j] == 'Q')  // 检查右上角
                return false;
        }
        return true;
    }
    public List<String> cToList(char[][] c){
        List<String> list = new ArrayList<>();
        for(char[] i : c)
            list.add(new String(i));
        return list;
    }
}
