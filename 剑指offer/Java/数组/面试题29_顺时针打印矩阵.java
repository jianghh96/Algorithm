// 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。

// 示例 1：

// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
// 输出：[1,2,3,6,9,8,7,4,5]

class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return new int[0];
        // 先从左往右，然后从上往下，接着从右往左，再行下往上
        // 弄清边界！
        int l = 0, r = matrix[0].length-1, t = 0, b = matrix.length-1;
        int x = 0;
        int[] res = new int[(r+1) * (b+1)];
        while(true){
            // 从左往右
            for(int i = l; i <= r; i++){
                res[x++] = matrix[t][i];
            }
            if(++t > b) break;
            
            // 从上往下
            for(int i = t; i <= b; i++){
                res[x++] = matrix[i][r];
            }
            if(--r < l) break;

            // 从右往左
            for(int i = r; i >= l; i--){
                res[x++] = matrix[b][i];
            }
            if(--b < t) break;

            // 从下往上
            for(int i = b; i >= t; i--){
                res[x++] = matrix[i][l];
            }
            if(++l > r) break;
        }
        return res;
    }
}


class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int rows = matrix.length, cols = matrix[0].length;
        int[] res = new int[rows * cols];
        int index = 0;
        int top = 0, below = rows-1, left = 0, right = cols-1;
        while(top <= below && left <= right){
            for(int i = left; i <= right; i++)
                res[index++] = matrix[top][i];
            top++;
            if(top > below) break;
            for(int i = top; i <= below; i++)
                res[index++] = matrix[i][right];
            right--;
            if(right < left) break;
            for(int i = right; i >= left; i--)
                res[index++] = matrix[below][i];
            below--;
            if(below < top) break;
            for(int i = below; i >= top; i--)
                res[index++] = matrix[i][left];
            left++;
            if(left > right) break;
        }
        return res; 
    }
}
