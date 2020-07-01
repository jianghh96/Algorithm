// 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。

// 示例 2:

// 输入: [0,0,1,2,5]
// 输出: True

// 除大小王外，所有牌需无重复 ；
// 设此 5 张牌中最大的牌为 max ，最小的牌为 min （大小王除外），则需满足：max - min < 5

// 方法一：排序 + 遍历

class Solution {
    public boolean isStraight(int[] nums) {
        int joker = 0;
        Arrays.sort(nums);
        for(int i = 0; i < 4; i++){
            if(nums[i] == 0)
                joker++;
            else if(nums[i] == nums[i+1])
                return false;
        }
        return nums[4] - nums[joker] < 5;
    }
}

// 集合 Set + 遍历

class Solution {
    public boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = -1, min = 14;
        for(int i = 0; i < 5; i++){
            if(nums[i] == 0)
                continue;
            else if(set.contains(nums[i]))
                return false;
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
            set.add(nums[i]);
        }
        return max - min < 5;
    }
}
