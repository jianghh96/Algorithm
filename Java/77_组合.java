// 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

// 示例:

// 输入: n = 4, k = 2

// 输出:
// [
//   [2,4],
//   [3,4],
//   [2,3],
//   [1,2],
//   [1,3],
//   [1,4],
// ]

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(n < k) return res;
        List<Integer> list = new ArrayList<>();
        if(n == k){
            for(int i = 1; i <= n; i++)
                list.add(i);
            res.add(list);
            return res;
        }
        backtracking(n, k, 1, res, list);
        return res;
    }
    public void backtracking(int n, int k, int begin, List<List<Integer>> res, List<Integer> list){
        if(k == 0){
            res.add(new ArrayList(list));
            return;
        }
        for(int i = begin; i+k-1 <= n; i++){
            list.add(i);
            backtracking(n, k-1, i+1, res, list);
            list.remove(list.size()-1);
        }
    }
}
