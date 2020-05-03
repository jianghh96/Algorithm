//  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。

// J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。

// 示例 :

// 输入: J = "aA", S = "aAAbbbb"
// 输出: 3

// 注意:

// S 和 J 最多含有50个字母。
// J 中的字符不重复。

// 哈希集合

class Solution {
    public int numJewelsInStones(String J, String S) {
        if(J.length() == 0 || S.length() == 0) return 0;
        Set<Character> set = new HashSet<>();
        int num = 0;
        for(int i = 0; i < J.length(); i++){
            set.add(J.charAt(i));
        }
        for(int j = 0; j < S.length(); j++){
            if(set.contains(S.charAt(j)))
                num++;
        }
        return num;
    }
}

class Solution {
    public int numJewelsInStones(String J, String S) {
        Set<Character> Jset = new HashSet();
        // 注意.toCharArray()的使用
        for (char j: J.toCharArray())
            Jset.add(j);

        int ans = 0;
        for (char s: S.toCharArray())
            if (Jset.contains(s))
                ans++;
        return ans;
    }
}
