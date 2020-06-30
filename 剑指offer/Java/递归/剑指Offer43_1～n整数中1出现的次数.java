// 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。

// 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。

// 示例 1：

// 输入：n = 12
// 输出：5
// 解析：1，10，11，12  ->  1 + 1 + 2 + 1 = 5

// 解题思路：https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/solution/javadi-gui-by-xujunyi/

class Solution {
    public int countDigitOne(int n) {
        return f(n);
    }
    public int f(int n){
        if(n <= 0) return 0;
        String s = String.valueOf(n);
        int high = s.charAt(0) - '0';
        int pow = (int) Math.pow(10, s.length()-1);
        int last = n - high * pow;
        if(high == 1)
            return f(pow-1) + last + 1 + f(last);
        else
            return pow + high * f(pow-1) + f(last);
    }
}
