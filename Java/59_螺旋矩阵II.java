// 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

// 示例:

// 输入: 3

// 输出:
// [
//  [ 1, 2, 3 ],
//  [ 8, 9, 4 ],
//  [ 7, 6, 5 ]
// ]

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int left = 0, right = n-1, top = 0, below = n-1;
        int num = 1;
        while(num <= n*n){
            for(int i = left; i <= right; i++)
                res[top][i] = num++;
            top++;
            for(int i = top; i <= below; i++)
                res[i][right] = num++;
            right--;
            for(int i = right; i >= left; i--)
                res[below][i] = num++;
            below--;
            for(int i = below; i >= top; i--)
                res[i][left] = num++;
            left++;
        }
        return res;
    }
}
