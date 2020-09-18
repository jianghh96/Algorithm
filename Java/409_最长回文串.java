// 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。

// 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。

// 注意:
// 假设字符串的长度不会超过 1010。

// 示例 1:

// 输入:
// "abccccdd"

// 输出:
// 7

// 哈希表

class Solution {
    public int longestPalindrome(String s) {
        if(s == null || s.length() == 0) return 0;
        if(s.length() == 1) return 1;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        int res = 0;
        for(char key : map.keySet()){
            int val = map.get(key);
            if((val & 1) == 0)
                res += val;
            else
                res += val-1;
            // res += val - (val & 1);
        }
        if(res < s.length())
            return res+1;
        else
            return res;
    }
}

// int数组计数

class Solution {
    public int longestPalindrome(String s) {
        int[] cnt = new int[58];
        for (char c : s.toCharArray()) {
            cnt[c - 'A'] += 1;
        }
        int ans = 0;
        for (int x: cnt) {
        // 字符出现的次数最多用偶数次。
        ans += x - (x & 1);
        }
        // 如果最终的长度小于原字符串的长度，说明里面某个字符出现了奇数次，那么那个字符可以放在回文串的中间，所以额外再加一。
        return ans < s.length() ? ans + 1 : ans;  
    }
}
