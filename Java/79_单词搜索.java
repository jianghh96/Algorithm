// 给定一个二维网格和一个单词，找出该单词是否存在于网格中。

// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

// 示例:

// board =
// [
//   ['A','B','C','E'],
//   ['S','F','C','S'],
//   ['A','D','E','E']
// ]

// 给定 word = "ABCCED", 返回 true
// 给定 word = "SEE", 返回 true
// 给定 word = "ABCB", 返回 false

// 深度优先搜索 + 回溯

class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(dfs(board, word, i, j))
                    return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int i, int j){
        if(board[i][j] == word.charAt(0)){
            if(word.substring(1, word.length()).length() == 0)
                return true;
            board[i][j] = ' ';
            if(i > 0 && dfs(board, word.substring(1, word.length()), i-1, j))
                return true;
            if(i < board.length-1 && dfs(board, word.substring(1, word.length()), i+1, j))
                return true;
            if(j > 0 && dfs(board, word.substring(1, word.length()), i, j-1))
                return true;
            if(j < board[0].length-1 && dfs(board, word.substring(1, word.length()), i, j+1))
                return true;
            board[i][j] = word.charAt(0);
            return false;
        }else{
            return false;
        }
    }
}
