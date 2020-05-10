// 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。

// 返回删除后的链表的头节点。

// 注意：此题对比原题有改动

// 示例 :

// 输入: head = [4,5,1,9], val = 5
// 输出: [4,1,9]

class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if(head == null) return head;
        if(head.val == val) return head.next;
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur != null){
            if(cur.val == val){
                pre.next = cur.next;
                break;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }
}
