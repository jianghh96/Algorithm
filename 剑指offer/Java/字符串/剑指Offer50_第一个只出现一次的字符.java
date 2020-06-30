// 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。

// 示例:

// s = "abaccdeff"
// 返回 "b"

// s = "" 
// 返回 " "

class Solution {
    public char firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] sChar = s.toCharArray();
        for(char sc : sChar){
            if(!map.containsKey(sc))
                map.put(sc, 1);
            else
                map.put(sc, map.get(sc)+1);
        }
        for(char sc : sChar){
            if(map.get(sc) == 1)
                return sc;
        }
        return ' ';
    }
}
