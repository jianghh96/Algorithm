// 请判断一个链表是否为回文链表。

// 示例 1:

// 输入: 1->2
// 输出: false
// 示例 2:

// 输入: 1->2->2->1
// 输出: true

// 栈，使链表逆序

class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        Stack<Integer> stack = new Stack<>();
        ListNode node = head;
        int len = 0;
        while(node != null){
            stack.push(node.val);
            node = node.next;
            len++;
        }
        for(int i = 0; i < len/2; i++){
            if(head.val != stack.pop()) return false;
            head = head.next;
        }
        return true;
    }
}

// 空间复杂度 O(1)

// 找到前半部分链表的尾节点。
// 反转后半部分链表。
// 判断是否为回文。
// 恢复链表。
// 返回结果。

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        // 找出前半段，反转后半段
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);
        // 前后半段比较
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        while (p2 != null) {
            if (p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }        
        // 再反转后半段
        firstHalfEnd.next = reverseList(secondHalfStart);
        return true;
    }
    // 反转链表
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
