// 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

// 说明：解集不能包含重复的子集。

// 示例:

// 输入: nums = [1,2,3]
// 输出:
// [
//   [3],
//   [1],
//   [2],
//   [1,2,3],
//   [1,3],
//   [2,3],
//   [1,2],
//   []
// ]

// 回溯思想，树结构去考虑

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        trackback(nums, 0, res, list);
        return res;
    }

    public void trackback(int[] nums, int k, List<List<Integer>> res, List<Integer> list){
        // 注意这里！把res和list当做全局变量不动，把list内容拷贝过去！
        res.add(new ArrayList(list));
        for(int i = k; i < nums.length; i++){
            list.add(nums[i]);
            trackback(nums, i+1, res, list);
            list.remove(list.size() - 1);
        }
    }
}
