// 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

// 说明：

// 拆分时可以重复使用字典中的单词。
// 你可以假设字典中没有重复的单词。

// 示例 2：

// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
// 输出: true
// 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//      注意你可以重复使用字典中的单词。

// 解题思路：https://leetcode-cn.com/problems/word-break/solution/dan-ci-chai-fen-by-leetcode/

// 方法1：记忆化回溯

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int maxNum = 0;
        Set<String> set = new HashSet<>();
        for(String wd : wordDict){
            set.add(wd);
            maxNum = Math.max(maxNum, wd.length());
        }
        // 这里要用包装器，默认为null; boolean默认为false!
        Boolean[] bool = new Boolean[s.length()];
        return check(s, set, bool, 0, maxNum);
    }
                                                 // 表示对象首字母必须大写Boolean
    public boolean check(String s, Set<String> set, Boolean[] bool, int start, int max){
        if(start == s.length())
            return true;
        if(bool[start] != null)
            return bool[start];
        for(int end = start+1; end <= start+max && end <= s.length(); end++){
            if(set.contains(s.substring(start, end))){
                if(check(s, set, bool, end, max)){
                    bool[start] = true;
                    return true;
                }
            }
        }
        bool[start] = false;
        return false;
    }
}


// 动态规划

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}

// 完全背包问题

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        for(int i = 1; i <= len; i++){
            for(String str : wordDict){
                int len_str = str.length();
                if(len_str <= i && str.equals(s.substring(i-len_str, i)))
                    dp[i] = dp[i] || dp[i-len_str];
            }
        }
        return dp[len];
    }
}
