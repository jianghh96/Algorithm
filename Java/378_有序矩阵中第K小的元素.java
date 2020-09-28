// 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。

// 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。

// 示例：

// matrix = [
//    [ 1,  5,  9],
//    [10, 11, 13],
//    [12, 13, 15]
// ],
// k = 8,

// 返回 13。

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int min = matrix[0][0], max = matrix[n-1][n-1];
        while(min < max){
            int mid = min + (max-min)/2;
            int count = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n && matrix[i][j] <= mid; j++){
                    count++;
                }
            }
            if(count >= k) max = mid;
            else min = mid+1;
        }
        return min;
    }
}
