// 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。

// 示例 1：

// 输入：nums = [4,1,4,6]
// 输出：[1,6] 或 [6,1]

// 解题思路：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/solution/jie-di-qi-jiang-jie-fen-zu-wei-yun-suan-by-eddievi/
// https://www.cnblogs.com/jpfss/p/11014780.html
// https://www.cnblogs.com/chuijingjing/p/9405598.html

class Solution {
    public int[] singleNumbers(int[] nums) {
        // 将所有的数异或起来
        int k = 0;
        for(int num : nums){
            k ^= num;
        }
        // 获得k中最低位的1
        int mask = 1;
        while((k & mask) == 0){
            mask <<= 1;
        }
        // 找出两个只出现一次的数字
        int a = 0, b = 0;
        for(int num : nums){
            if((num & mask) == 0)
                a ^= num;
            else
                b ^= num;
        }
        return new int[]{a, b};
    }
}
