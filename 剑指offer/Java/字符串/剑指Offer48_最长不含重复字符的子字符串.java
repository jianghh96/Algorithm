// 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。

// 示例 3:

// 输入: "pwwkew"
// 输出: 3
// 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

// 双指针 + 哈希表

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) return s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        int start = 0, res = 0;
        for(int end = 0; end < arr.length; end++){
            if(map.containsKey(arr[end]))
                start = Math.max(start, map.get(arr[end])+1);
            map.put(arr[end], end);
            res = Math.max(res, end-start+1);
        }
        return res;
    }
}
