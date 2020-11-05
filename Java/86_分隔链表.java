// 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。

// 你应当保留两个分区中每个节点的初始相对位置。

// 示例:

// 输入: head = 1->4->3->2->5->2, x = 3
// 输出: 1->2->2->4->3->5

class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode head1 = new ListNode(0);
        ListNode head2 = new ListNode(0);
        ListNode l1 = head1;
        ListNode l2 = head2;
        while(head != null){
            if(head.val < x){
                l1.next = head;
                l1 = l1.next;
                head = head.next;
            }else{
                l2.next = head;
                l2 = l2.next;
                head = head.next;
            }
        }
        l2.next = null;
        l1.next = head2.next;
        return head1.next;
    }
}
