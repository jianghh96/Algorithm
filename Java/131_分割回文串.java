// 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。

// 返回 s 所有可能的分割方案。

// 示例:

// 输入: "aab"

// 输出:
// [
//   ["aa","b"],
//   ["a","a","b"]
// ]

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if(s == null || s.length() == 0) return res;
        List<String> list = new ArrayList<>();
        if(s.length() == 1){
            list.add(s);
            res.add(list);
            return res;
        }
        backtracking(s, 0, res, list);
        return res;
    }
    public void backtracking(String s, int begin, List<List<String>> res, List<String> list){
        if(begin == s.length()){
            res.add(new ArrayList(list));
            return;
        }
        for(int i = begin; i < s.length(); i++){
            String subS = s.substring(begin, i+1);
            if(judge(subS)){
                list.add(subS);
                backtracking(s, i+1, res, list);
                list.remove(list.size()-1);
            }
        }
    }
    public boolean judge(String s){
        if(s == null || s.length() == 0) return true;
        int left = 0, right = s.length()-1;
        while(left <= right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
