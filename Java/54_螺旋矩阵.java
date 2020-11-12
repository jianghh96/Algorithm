// 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。

// 示例 1:

// 输入:
// [
//  [ 1, 2, 3 ],
//  [ 4, 5, 6 ],
//  [ 7, 8, 9 ]
// ]
// 输出: [1,2,3,6,9,8,7,4,5]

// 示例 2:

// 输入:
// [
//   [1, 2, 3, 4],
//   [5, 6, 7, 8],
//   [9,10,11,12]
// ]
// 输出: [1,2,3,4,8,12,11,10,9,5,6,7]

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix.length == 0 || matrix[0].length == 0) return res;
        while(matrix.length != 0){
            for(int num : matrix[0])
                res.add(num);
            matrix = changeMatrix(matrix);
        }
        return res;
    }
    public int[][] changeMatrix(int[][] matrix){
        int m = matrix.length, n = matrix[0].length;
        int[][] mtx = new int[n][m-1];
        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){
                mtx[n-1-j][i-1] = matrix[i][j];
            }
        }
        return mtx;
    }
}
