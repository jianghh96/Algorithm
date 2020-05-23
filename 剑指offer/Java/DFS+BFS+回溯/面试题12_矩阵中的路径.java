// 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。

// [["a","b","c","e"],
// ["s","f","c","s"],
// ["a","d","e","e"]]

// 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。

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
