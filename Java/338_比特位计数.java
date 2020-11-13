// 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。

// 示例 1:

// 输入: 2
// 输出: [0,1,1]

// 示例 2:

// 输入: 5
// 输出: [0,1,1,2,1,2]

class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        // 最后设置位是从右到左第一个为1的位。使用 x &= x - 1 将该位设置为0
        for(int i = 1; i <= num; i++){
            res[i] = res[i & (i-1)] + 1;
        }
        return res;
    }
}
