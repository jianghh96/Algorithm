// 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

// 示例:

// 给定 1->2->3->4, 你应该返回 2->1->4->3.

class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode pre = node;
        while(pre.next != null && pre.next.next != null){
            ListNode start = pre.next;
            ListNode end = start.next;
            pre.next = end;
            // 注意这点
            start.next = end.next;
            end.next = start;
            pre = start;
        }
        return node.next;
    }
}

// 递归

class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode next = head.next;
        head.next = swapPairs(head.next.next);
        next.next = head; 
        return next;
    }
}
