// 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点

// 两次遍历

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n <= 0){
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
        if(n > len){
            return head;
        }
        int num = len - n;
        cur = pre;
        while(num > 0){
            cur = cur.next;
            --num;
        }
        cur.next = cur.next.next;
        return pre.next;
    }
}


// 一次遍历

class Solution {
	  public ListNode removeNthFromEnd(ListNode head, int n) {
		    //增加一个特殊节点方便边界判断
		    ListNode pre = new ListNode(0);
		    pre.next = head;
		    ListNode a = pre;
		    ListNode b = pre;
		    //第一次，b指针先往前走n步
		    while(n > 0 && b != null) {
		       	--n;
			      b = b.next;
		    }
		    //假设整个链表长5，n是10，那么第一次遍历完后b就等用于空了
		    //于是后面的判断就不用做了，直接返回
		    if(b==null) {
			      return head;
		    }
	    	//第二次，b指针走到链表最后，a指针也跟着走
		    //当遍历结束时，a指针就指向要删除的节点的前一个位置
		    while(b.next != null) {
			      a = a.next;
			      b = b.next;
		    }
		    //删除节点并返回
		    a.next = a.next.next;
		    return pre.next;
	  }
}
