// 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：

// 每行中的整数从左到右按升序排列。
// 每行的第一个整数大于前一行的最后一个整数。

// 示例 1：

// 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
// 输出：true

// 示例 2：

// 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
// 输出：false

// 示例 3：

// 输入：matrix = [], target = 0
// 输出：false

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        if(target < matrix[0][0] || target > matrix[m-1][n-1]) return false;
        int high = 0, low = m-1, row = 0;
        while(high < low){
            int mid = high + (low-high)/2;
            if(target <= matrix[mid][n-1]) low = mid;
            else high = mid+1;
        }
        row = low;
        int left = 0, right = n-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(matrix[row][mid] == target) return true;
            else if(matrix[row][mid] < target) left = mid+1;
            else right = mid-1;
        }
        return false;
    }
}
