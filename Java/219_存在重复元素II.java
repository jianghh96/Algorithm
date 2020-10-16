// 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。

// 示例 1:

// 输入: nums = [1,2,3,1], k = 3
// 输出: true

// 示例 2:

// 输入: nums = [1,0,1,1], k = 1
// 输出: true

// 示例 3:

// 输入: nums = [1,2,3,1,2,3], k = 2
// 输出: false

// hashmap

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length < 2 || k < 1) return false;
        Map<Integer, List<Integer>> map = new HashMap<>();
        int len = nums.length;
        for(int i = 0; i < len; i++){
            if(!map.containsKey(nums[i])){
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }else{
                map.get(nums[i]).add(i);
            }
        }
        for(int num : map.keySet()){
            List<Integer> list = map.get(num);
            if(list.size() >= 2){
                for(int i = 1; i < list.size(); i++){
                    if(list.get(i)-list.get(i-1) <= k)
                        return true;
                }
            }
        }
        return false;
    }
}

// hashset

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length < 2 || k < 1) return false;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i]))
                return true;
            set.add(nums[i]);
            if(set.size() > k)
                set.remove(nums[i-k]);
        }
        return false;
    }
}
