// 给定一个可包含重复数字的序列，返回所有不重复的全排列。

// 示例:

// 输入: [1,1,2]

// 输出:
// [
//   [1,1,2],
//   [1,2,1],
//   [2,1,1]
// ]

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        List<Integer> list = new ArrayList<>();
        boolean[] state = new boolean[nums.length];
        int depth = 0;
        Arrays.sort(nums);
        backtracking(nums, 0, res, list, state);
        return res;
    }
    public void backtracking(int[] nums, int depth, List<List<Integer>> res, List<Integer> list, boolean[] state){
        if(depth == nums.length){
            res.add(new ArrayList(list));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            // 去重
            // 写 !state[i-1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择，同一层不能重复使用！
            if(i > 0 && nums[i] == nums[i-1] && !state[i-1])
                continue;
            if(!state[i]){
                list.add(nums[i]);
                state[i] = true;
                backtracking(nums, depth+1, res, list, state);
                state[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
}
