// 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

// 示例:

// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
// 输出:
// [
//   ["ate","eat","tea"],
//   ["nat","tan"],
//   ["bat"]
// ]

// 说明：
// 所有输入均为小写字母。
// 不考虑答案输出的顺序。

// 当且仅当它们的排序字符串相等时，两个字符串是字母异位词。

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return new ArrayList();
        // 用哈希表
        Map<String, List> map = new HashMap<>();
        for(String str : strs){
            char[] ca = str.toCharArray();
            // 对字符数组排序
            Arrays.sort(ca);
            // 字符数组合并为字符串方法
            String key = String.valueOf(ca);
            // 判断key在不在哈希表中
            if(!map.containsKey(key)) map.put(key, new ArrayList());
            map.get(key).add(str);
        }
        // 注意这种形式！！！
        return new ArrayList(map.values());
    }
}
