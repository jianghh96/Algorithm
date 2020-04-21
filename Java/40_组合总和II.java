// 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

// candidates 中的每个数字在每个组合中只能使用一次。

// 说明：
// 所有数字（包括目标数）都是正整数。
// 解集不能包含重复的组合。 

// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
// 所求解集为:
// [
//   [1, 7],
//   [1, 2, 5],
//   [2, 6],
//   [1, 1, 6]
// ]

// 回溯！！！ 如何去重？

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 全不全局变量无所谓
        List<List<Integer>> lists = new ArrayList<>();
        if (candidates.length == 0 || target < 0) {
            return lists;
        }
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        process(0, candidates, target, list, lists);
        return lists;
    }

    private void process(int start, int[] candidates, int target, List<Integer> list, List<List<Integer>> lists) {
        //递归的终止条件
        if (target < 0) {
            return;
        }
        if (target == 0) {
            lists.add(new ArrayList<>(list));
        } else {
            for (int i = start; i < candidates.length; i++) {
                // 核心：去重
                if(i > start && candidates[i] == candidates[i-1]) continue;
                list.add(candidates[i]);
                //因为每个数字不能重复使用，所以递归得从下个元素开始
                process(i+1, candidates, target - candidates[i], list, lists);
                list.remove(list.size() - 1);
            }
        }
    }
}
