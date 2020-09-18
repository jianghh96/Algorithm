// 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

// 示例 1:

// 输入: s = "anagram", t = "nagaram"
// 输出: true

// 示例 2:

// 输入: s = "rat", t = "car"
// 输出: false

// 说明:
// 你可以假设字符串只包含小写字母。

// 进阶:
// 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？

// 思路：
// 标签：哈希映射
// 首先判断两个字符串长度是否相等，不相等则直接返回 false
// 若相等，则初始化 26 个字母哈希表，遍历字符串 s 和 t
// s 负责在对应位置增加，t 负责在对应位置减少
// 如果哈希表的值都为 0，则二者是字母异位词

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] nums = new int[26];
        for(int i = 0; i < s.length(); i++){
            nums[s.charAt(i)-'a']++;
            nums[t.charAt(i)-'a']--;
        }
        for(int i = 0; i < 26; i++){
            if(nums[i] != 0) return false;
        }
        return true;
    }
}
