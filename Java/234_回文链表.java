// 请判断一个链表是否为回文链表。

// 示例 1:

// 输入: 1->2
// 输出: false
// 示例 2:

// 输入: 1->2->2->1
// 输出: true

class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        List<Integer> values = new ArrayList<>();
        ListNode node = head;
        while(node != null){
            values.add(node.val);
            node = node.next;
        }
        int left = 0;
        int right = values.size() - 1;
        while (left < right) {
            if (!values.get(left).equals(values.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
