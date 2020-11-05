// 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。

// 示例 1:

// 输入: 1->2->3->3->4->4->5
// 输出: 1->2->5

// 示例 2:

// 输入: 1->1->1->2->3
// 输出: 2->3

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode pre = node;
        ListNode cur = head;
        while(cur != null && cur.next != null){
            if(cur.val == cur.next.val){
                while(cur != null && cur.next != null && cur.val == cur.next.val)
                    cur = cur.next;
                pre.next = cur.next;
                // 注意：这里只更新cur，不更新pre
                // [1,2,3,3,4,4,5] 删除3,3后，还会删除4,4
                cur = cur.next;
            }else{
                pre = pre.next;
                cur = cur.next;
            }
        }
        return node.next;
    }
}
