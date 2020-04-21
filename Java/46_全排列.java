// 给定一个 没有重复 数字的序列，返回其所有可能的全排列。

// 示例:

// 输入: [1,2,3]
// 输出:
// [
//   [1,2,3],
//   [1,3,2],
//   [2,1,3],
//   [2,3,1],
//   [3,1,2],
//   [3,2,1]
// ]

// 方法：回溯（排列、组合想到回溯算法，树形结构分析，树上深度优先遍历）

// https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if(len == 0)
            return res;
        List<Integer> list = new ArrayList<>();
        int depth = 0;
        boolean[] used = new boolean[len];

        traceback(nums, len, depth, res, list, used);
        
        return res;
    }

    public void traceback(int[] nums, int len, int depth, List<List<Integer>> res, List<Integer> path, boolean[] used){
        if(depth == len){
            // 注意这里
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < len; i++){
            if(!used[i]){
                path.add(nums[i]);
                used[i] = true;
                // 递归
                traceback(nums, len, depth+1, res, path, used);
                // 回溯：状态重置，是从深层结点回到浅层结点的过程
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
