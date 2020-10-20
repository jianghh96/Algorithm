// 实现 int sqrt(int x) 函数。

// 计算并返回 x 的平方根，其中 x 是非负整数。

// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

// 示例 1:

// 输入: 4
// 输出: 2

// 示例 2:

// 输入: 8
// 输出: 2
// 说明: 8 的平方根是 2.82842..., 
// 由于返回类型是整数，小数部分将被舍去。

class Solution {
    public int mySqrt(int x) {
        if(x <= 1) return x;
        int left = 1, right = x/2;
        while(left <= right){
            int mid = left + (right-left)/2;
            int sqrt = x / mid;
            if(sqrt == mid)
                return mid;
            else if(sqrt > mid)
                left = mid+1;
            else
                right = mid-1;
        }
        return right;
    }
}

class Solution {
    public int mySqrt(int x) {
        if(x <= 1) return x;
        long left = 1, right = x/2;
        while(left <= right){
            long mid = left + (right-left)/2;
            long sum1 = mid * mid;
            long sum2 = (mid+1) * (mid+1);
            if(sum1 == x || (sum1 < x && sum2 > x))
                return (int) mid;
            else if(sum1 > x)
                right = mid-1;
            else
                left = mid+1;
        }
        return x;
    }
}
