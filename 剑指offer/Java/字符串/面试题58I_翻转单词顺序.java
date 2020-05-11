// 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。

// 方法1：分割 + 倒序

class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return s;
        // 删除首尾空格，分割字符串
        String[] ss = s.trim().split(" ");
        StringBuilder res = new StringBuilder();
        // 倒序遍历单词列表
        for(int i = ss.length-1; i >= 0; i--){
            // 遇到空单词则跳过，注意用equals，且为“”
            if(ss[i].equals("")) continue;
            // 将单词拼接至 StringBuilder
            res.append(ss[i] + " ");
        }
        // 转化为字符串，删除尾部空格，并返回
        return res.toString().trim();
    }
}

// 双指针

class Solution {
    public String reverseWords(String s) {
        s = s.trim(); // 删除首尾空格
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while(i >= 0) {
            while(i >= 0 && s.charAt(i) != ' ') i--; // 搜索首个空格
            res.append(s.substring(i + 1, j + 1) + " "); // 添加单词
            while(i >= 0 && s.charAt(i) == ' ') i--; // 跳过单词间空格
            j = i; // j 指向下个单词的尾字符
        }
        return res.toString().trim(); // 转化为字符串并返回
    }
}
