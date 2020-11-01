// 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。

// 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。

// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。

// 示例 1：

// 输入：s = "25525511135"
// 输出：["255.255.11.135","255.255.111.35"]

// 示例 2：

// 输入：s = "0000"
// 输出：["0.0.0.0"]

// 示例 3：

// 输入：s = "1111"
// 输出：["1.1.1.1"]

// 示例 4：

// 输入：s = "010010"
// 输出：["0.10.0.10","0.100.1.0"]

// 提示：
// 0 <= s.length <= 3000
// s 仅由数字组成

// 思路：https://leetcode-cn.com/problems/restore-ip-addresses/solution/hui-su-suan-fa-hua-tu-fen-xi-jian-zhi-tiao-jian-by/

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        int len = s.length();
        if (s == null || len > 12 || len < 4)
            return res;
        Deque<String> path = new ArrayDeque<>(4);
        backtracking(s, len, 0, 4, path, res);
        return res;
    }
    // remain: 需要一个变量记录剩余多少段还没被分割
    private void backtracking(String s, int len, int begin, int remain, Deque<String> path, List<String> res) {
        if (begin == len) {
            if (remain == 0)
                res.add(String.join(".", path));
            return;
        }
        for (int i = begin; i < begin + 3; i++) {
            if (i >= len) {
                break;
            }
            if (len-1-i > (remain-1) * 3) {
                continue;
            }
            if (judgeIpSegment(s, begin, i)) {
                String currentIpSegment = s.substring(begin, i + 1);
                path.addLast(currentIpSegment);
                backtracking(s, len, i+1, remain-1, path, res);
                path.removeLast();
            }
        }
    }
    private boolean judgeIpSegment(String s, int left, int right) {
        if (right > left && s.charAt(left) == '0')
            return false;
        int num = 0;
        while (left <= right) {
            num = num * 10 + (s.charAt(left) - '0');
            left++;
        }

        return num >= 0 && num <= 255;
    }
}
