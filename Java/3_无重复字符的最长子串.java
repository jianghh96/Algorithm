// 给定一个字符串，请你找出其中不含有重复字符的 最长子串的长度。

// 输入: "abcabcbb"
// 输出: 3 
// 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

// 双指针 + 哈希表

// s.charAt(end) 找到字符串指定索引的字符char

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;
        int start = 0;
        char[] array = s.toCharArray();      // s.charAt(end) 找到字符串指定索引的字符char
        for(int end = 0; end <= s.length()-1; end++){
            if(map.containsKey(array[end]))
                start = Math.max(start, map.get(array[end])+1);     // 用Math.max()
            map.put(array[end], end);
            res = Math.max(res, end-start+1);
        }
        return res;
    }
}
