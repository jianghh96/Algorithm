// 给定一个未排序的整数数组，找出最长连续序列的长度。

// 要求算法的时间复杂度为 O(n)。

// 示例:

// 输入: [100, 4, 200, 1, 3, 2]
// 输出: 4
// 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。

// 方法1：HashSet

class Solution {
    public int longestConsecutive(int[] nums) {
        // 不关心集合元素顺序用HashSet!
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int longest = 0;
        for(int num : nums){
            if(!set.contains(num-1)){
                int curNum = num;
                int curLong = 1;
                while(set.contains(curNum+1)){
                    curNum++;
                    curLong++;
                }
                longest = Math.max(longest, curLong);
            }
        }
        return longest;
    }
}

// 排序：时间复杂度：O(nlgn)

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int longestStreak = 1;
        int currentStreak = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                if (nums[i] == nums[i-1]+1) {
                    currentStreak += 1;
                }
                else {
                    longestStreak = Math.max(longestStreak, currentStreak);
                    currentStreak = 1;
                }
            }
        }
        return Math.max(longestStreak, currentStreak);
    }
}
