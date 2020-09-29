// 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。

// 给定一个 M x N 的矩阵，当且仅当它是托普利茨矩阵时返回 True。

// 示例 1:

// 输入: 
// matrix = [
//   [1,2,3,4],
//   [5,1,2,3],
//   [9,5,1,2]
// ]
// 输出: True

// 解释:
// 在上述矩阵中, 其对角线为:
// "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。
// 各条对角线上的所有元素均相同, 因此答案是True。

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i > 0 && j > 0 && matrix[i][j] != matrix[i-1][j-1])
                    return false;
            }
        }
        return true;
    }
}
