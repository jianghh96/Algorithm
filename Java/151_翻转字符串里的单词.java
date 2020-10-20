// 给定一个字符串，逐个翻转字符串中的每个单词。

// 说明：

// 无空格字符构成一个 单词 。
// 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
// 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 
// 示例 1：

// 输入："the sky is blue"
// 输出："blue is sky the"
// 示例 2：

// 输入："  hello world!  "
// 输出："world! hello"
// 解释：输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。

// 双指针

class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        int j = s.length()-1, i = j;
        StringBuilder res = new StringBuilder();
        while(i >= 0){
            while(i >= 0 && s.charAt(i) != ' ')
                i--;
            res.append(s.substring(i+1, j+1) + " ");
            while(i >= 0 && s.charAt(i) == ' ')
                i--;
            j = i;
        }
        return res.toString().trim();
    }
}

// 去空格再切割，注意equals方法

class Solution {
    public String reverseWords(String s) {
        String[] str = s.trim().split(" ");
        StringBuilder res = new StringBuilder();
        for(int i = str.length-1; i >= 0; i--){
            // String重写equals方法
            if(!str[i].equals(""))
                res.append(str[i] + " ");
        }
        return res.toString().trim();
    }
}
