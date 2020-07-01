// 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。

// 示例 1：

// 输入：nums = [3,4,3,3]
// 输出：4

// 哈希表

class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            // 注意getOrDefault用法
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        for(int num : nums){
            if(map.get(num) == 1)
                return num;
        }
        return 0;
    }
}

// 位运算 优先状态自动机
// https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/solution/mian-shi-ti-56-ii-shu-zu-zhong-shu-zi-chu-xian-d-4/

class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
}
