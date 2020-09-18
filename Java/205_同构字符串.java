// 给定两个字符串 s 和 t，判断它们是否是同构的。

// 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。

// 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。

// 示例 1:

// 输入: s = "egg", t = "add"
// 输出: true

// 示例 2:

// 输入: s = "foo", t = "bar"
// 输出: false

// 哈希表 相互映射

// 利用一个 map 来处理映射。对于 s 到 t 的映射，我们同时遍历 s 和 t ，假设当前遇到的字母分别是 c1 和 c2 。
// 如果 map[c1] 不存在，那么就将 c1 映射到 c2 ，即 map[c1] = c2。
// 如果 map[c1] 存在，那么就判断 map[c1] 是否等于 c2，也就是验证之前的映射和当前的字母是否相同。

// 需要验证 s - > t 和 t -> s 两个方向！！！

class Solution {
    public boolean isIsomorphic(String s, String t) {
        // s 映射 t, t 映射 s都要成立
        return helper(s, t) && helper(t, s);
    }
    public boolean helper(String s, String t){
        // 字符映射
        int len = s.length();
        HashMap<Character, Character> map = new HashMap<>();
        for(int i = 0; i < len; i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(map.containsKey(c1)){
                if(map.get(c1) != c2)
                    return false;
            }else{
                map.put(c1, c2);
            }
        }
        return true;
    }
}
