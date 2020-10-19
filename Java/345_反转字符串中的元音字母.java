// 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。

// 示例 1：

// 输入："hello"
// 输出："holle"

// 示例 2：

// 输入："leetcode"
// 输出："leotcede"
 
// 提示：
// 元音字母不包含字母 "y" 。

class Solution {
    public String reverseVowels(String s) {
        if(s == null || s.length() < 2) return s;
        Set<Character> set = new HashSet<>();
        // Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] letter = new char[]{'a','e','i','o','u','A','E','I','O','U'};
        for(char c : letter)
            set.add(c);
        char[] s_char = s.toCharArray();
        int left = 0, right = s_char.length-1;
        while(left < right){
            while(left < s_char.length && !set.contains(s_char[left]))
                left++;
            while(right >= 0 && !set.contains(s_char[right]))
                right--;
            if(left >= right)
                break;
            swap(s_char, left, right);
            left++;
            right--;
        }
        return new String(s_char);
    }
    private void swap(char[] s_char, int i, int j){
        char tmp = s_char[i];
        s_char[i] = s_char[j];
        s_char[j] = tmp;
    }
}
