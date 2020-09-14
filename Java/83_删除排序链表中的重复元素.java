// 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

// 示例 1:

// 输入: 1->1->2
// 输出: 1->2

// 示例 2:

// 输入: 1->1->2->3->3
// 输出: 1->2->3

// 解法1：双指针

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pre = head, cur = head.next;
        while(cur != null){
            if(pre.val == cur.val){
                cur = cur.next;
            }else{
                pre.next = cur;
                pre = pre.next;
                cur = cur.next;
            }
        }
        pre.next = null;
        return head;
    }
}

// 解法2：单指针

public ListNode deleteDuplicates(ListNode head) {
    ListNode current = head;
    while (current != null && current.next != null) {
        if (current.next.val == current.val) {
            current.next = current.next.next;
        } else {
            current = current.next;
        }
    }
    return head;
}
