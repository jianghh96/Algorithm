// 给定一个带有头结点 head 的非空单链表，返回链表的中间结点
// 如果有两个中间结点，则返回第二个中间结点

// 先遍历链表一遍

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode cur = pre;
        int len = 0;
        while(cur.next != null){
            len++;
            cur = cur.next;
        }
        int num = len / 2 + 1;
        cur = pre;
        while(num > 0){
            cur = cur.next;
            --num;
        }
        return cur;
    }
}


// 快慢指针

public class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
