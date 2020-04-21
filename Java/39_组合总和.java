// 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

// candidates 中的数字可以无限制重复被选取。

// 输入: candidates = [2,3,5], target = 8,
// 所求解集为:
// [
//   [2,2,2,2],
//   [2,3,3],
//   [3,5]
// ]

// 方法1：回溯！！！(DFS，深度优先搜索) >>>>  for循环 + 递归

// https://leetcode-cn.com/problems/combination-sum/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-2/
// https://leetcode-cn.com/problems/combination-sum/solution/fei-chang-xiang-xi-de-di-gui-hui-su-tao-lu-by-re-2/

class Solution {
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || target < 0) {
            return lists;
        }
        List<Integer> list = new ArrayList<>();
        process(0, candidates, target, list);
        return lists;
    }

    private void process(int start, int[] candidates, int target, List<Integer> list) {
        //递归的终止条件
        if (target < 0) {
            return;
        }
        if (target == 0) {
            lists.add(new ArrayList<>(list));
        } else {
            for (int i = start; i < candidates.length; i++) {
                list.add(candidates[i]);
                //因为每个数字都可以使用无数次，所以递归还可以从当前元素开始
                process(i, candidates, target - candidates[i], list);
                // 回溯！！！
                list.remove(list.size() - 1);
            }
        }
    }
}

// 方法2：动态规划

// https://leetcode-cn.com/problems/combination-sum/solution/chao-qiang-gifzhu-ni-shi-yong-dong-tai-gui-hua-qiu/
