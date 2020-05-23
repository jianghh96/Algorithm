// 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。

// 示例 1：

// 输入：00000000000000000000000000001011
// 输出：3
// 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。

// 方法一：逐位判断

public class Solution {
    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }
}

// 方法二：巧用 n&(n−1)

// 算法流程：
// 初始化数量统计变量 res
// 循环消去最右边的 1 ：当 n = 0 时跳出。
// res += 1 ： 统计变量加 1
// n &= n - 1 ： 消去数字 n 最右边的 1
// 返回统计数量 res

public class Solution {
    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0) {
            res++;
            n &= n - 1;
        }
        return res;
    }
}
