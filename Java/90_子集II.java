// 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

// 说明：解集不能包含重复的子集。

// 示例:

// 输入: [1,2,2]

// 输出:
// [
//   [2],
//   [1],
//   [1,2,2],
//   [2,2],
//   [1,2],
//   []
// ]

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(nums, 0, res, list);
        return res;
    }
    public void backtracking(int[] nums, int begin, List<List<Integer>> res, List<Integer> list){
        res.add(new ArrayList(list));
        for(int i = begin; i < nums.length; i++){
            // 注意 i > begin 而不是大于 0
            if(i > begin && nums[i] == nums[i-1])
                continue;
            list.add(nums[i]);
            backtracking(nums, i+1, res, list);
            list.remove(list.size()-1);
        }
    }
}


class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] state = new boolean[nums.length];
        backtracking(nums, state, 0, res, list);
        return res;
    }
    public void backtracking(int[] nums, boolean[] state, int begin, List<List<Integer>> res, List<Integer> list){
        res.add(new ArrayList(list));
        for(int i = begin; i < nums.length; i++){
            if(i > begin && nums[i] == nums[i-1] && !state[i-1])
                continue;
            list.add(nums[i]);
            state[i] = true;
            backtracking(nums, state, i+1, res, list);
            state[i] = false;
            list.remove(list.size()-1);
        }
    }
}
