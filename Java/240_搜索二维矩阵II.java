// 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：

// 每行的元素从左到右升序排列。
// 每列的元素从上到下升序排列。
// 示例:

// 现有矩阵 matrix 如下：

// [
//   [1,   4,  7, 11, 15],
//   [2,   5,  8, 12, 19],
//   [3,   6,  9, 16, 22],
//   [10, 13, 14, 17, 24],
//   [18, 21, 23, 26, 30]
// ]

// 给定 target = 5，返回 true。
// 给定 target = 20，返回 false。

// 解题思路：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-5-4/

// 方法一：二分法(排序数组想到二分法！)
// 对每一行使用二分法，没有就到下一行

// 方法二：从右上角出发，往左递减，往下递增，类似于二叉搜索树思想

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 从右上角出发，往左递减，往下递增，类似于二叉搜索树思想！
        if(matrix.length == 0 || matrix[0].length == 0)
            return false;
        int row = 0;
        int col = matrix[0].length - 1;
        while(row < matrix.length && col >= 0){
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] > target){
                col--;
            }else{
                row++;
            }
        }
        return false;
    }
}
