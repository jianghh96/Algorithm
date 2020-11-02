// 编写一个程序，通过填充空格来解决数独问题。

// 一个数独的解法需遵循如下规则：

// 数字 1-9 在每一行只能出现一次。
// 数字 1-9 在每一列只能出现一次。
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
// 空白格用 '.' 表示。

// 提示：

// 给定的数独序列只包含数字 1-9 和字符 '.' 。
// 你可以假设给定的数独只有唯一解。
// 给定数独永远是 9x9 形式的。

class Solution {
    public void solveSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    int box = i / 3 * 3 + j / 3;
                    int num = board[i][j] - '1';
                    rows[i][num] = cols[j][num] = boxes[box][num] = true;                  
                }
            }
        }
        backtracking(board, 0, rows, cols, boxes);
    }
    public boolean backtracking(char[][] board, int begin, boolean[][] rows, boolean[][] cols, boolean[][] boxes){
        if(begin == 81)
            return true;
        int row = begin / 9, col = begin % 9;
        if(board[row][col] != '.')
            return backtracking(board, begin+1, rows, cols, boxes);
        int box = row / 3 * 3 + col / 3;
        for(int i = 0; i < 9; i++){
            if(rows[row][i] || cols[col][i] || boxes[box][i])
                continue;
            board[row][col] = (char) (i + '1');
            rows[row][i] = cols[col][i] = boxes[box][i] = true;
            if(backtracking(board, begin+1, rows, cols, boxes))
                return true;
            rows[row][i] = cols[col][i] = boxes[box][i] = false;
            board[row][col] = '.';
        }
        return false;
    }
}
