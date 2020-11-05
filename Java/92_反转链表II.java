// 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

// 说明:
// 1 ≤ m ≤ n ≤ 链表长度。

// 示例:

// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
// 输出: 1->4->3->2->5->NULL

// 原地翻转

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode p = node;
        for(int i = 1; i < m; i++)
            p = p.next;
        ListNode start = p.next;
        for(int i = m; i < n; i++){
            ListNode next = start.next;
            start.next = next.next;
            next.next = p.next;
            p.next = next;
        }
        return node.next;
    }
}

// 确定位置再借助反转方法

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode p = node;
        for(int i = 1; i <= m-1; i++)
            p = p.next;
        ListNode start = p.next;
        ListNode end = start;
        for(int i = 1; i <= n-m; i++)
            end = end.next;
        ListNode next = end.next;
        end.next = null;
        p.next = reverseList(start);
        start.next = next;
        return node.next;
    }
    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
