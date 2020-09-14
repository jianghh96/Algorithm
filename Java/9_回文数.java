// 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

// 示例 1:

// 输入: 121
// 输出: true

//示例 2:

// 输入: -121
// 输出: false
// 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。

// 解法一：双指针

class Solution {
    public boolean isPalindrome(int x) {
        String s = (new StringBuilder(""+x)).toString();
        if(s.length() == 1) return true;
        int i = 0, j = s.length()-1;
        while(i < j){
            char left = s.charAt(i);
            char right = s.charAt(j);
            if(left != right) return false;
            i++;
            j--;
        }
        return true;
    }
}

// 解法二：取出后半段数字进行翻转与前半段比较

// 每次进行取余操作（%10），取出最低的数字：y = x % 10
// 将最低的数字加到取出数的末尾：revertNum = revertNum * 10 + y
// 每取一个最低位数字，x 都要自除以 10
// 判断 x 是不是小于 revertNum ，当它小于的时候，说明数字已经对半或者过半了
// 最后，判断奇偶数情况：如果是偶数的话，revertNum 和 x 相等；如果是奇数的话，最中间的数字就在revertNum 的最低位上，将它除以 10 以后应该和 x 相等。

class Solution {
    public boolean isPalindrome(int x) {
        // 注意被10整除不行
        if(x < 0 || (x % 10 == 0 && x != 0)) return false;
        int reverseNum = 0;
        while(x > reverseNum){
            reverseNum = reverseNum * 10 + x % 10;
            x = x / 10;
        }
        return x == reverseNum || x == reverseNum / 10;
    }
}
