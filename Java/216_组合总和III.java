// 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。

// 说明：

// 所有数字都是正整数。
// 解集不能包含重复的组合。 

// 示例 1:

// 输入: k = 3, n = 7
// 输出: [[1,2,4]]

// 示例 2:

// 输入: k = 3, n = 9
// 输出: [[1,2,6], [1,3,5], [2,3,4]]

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if(n < 0 || n > k * 9 || n < k) return res;
        List<Integer> list = new ArrayList<>();
        if(n == k){
            for(int i = 0; i < k; i++)
                list.add(1);
            res.add(list);
            return res;
        }
        backtracking(k, n, 1, res, list);
        return res;
    }
    public void backtracking(int k, int n, int begin, List<List<Integer>> res, List<Integer> list){
        if(k == 0 && n == 0){
            res.add(new ArrayList(list));
            return;
        }
        if(k == 0 || n == 0 || begin > n)
            return;
        for(int i = begin; i <= 9; i++){
            list.add(i);
            backtracking(k-1, n-i, i+1, res, list);
            list.remove(list.size()-1);
        }
    }
}
