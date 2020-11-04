// 对链表进行插入排序。

// 插入排序算法：

// 1.插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
// 2.每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
// 3.重复直到所有输入数据插入完为止。
 
// 示例 1：

// 输入: 4->2->1->3
// 输出: 1->2->3->4

// 示例 2：

// 输入: -1->5->3->4->0
// 输出: -1->0->3->4->5

class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode p = new ListNode(0);
        p.next = head;
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur != null){
            if(cur.val >= pre.val){
                pre = cur;
                cur = cur.next;
            }else{
                ListNode node = p;
                while(node.next != cur && node.next.val < cur.val)
                    node = node.next;
                pre.next = cur.next;
                cur.next = node.next;
                node.next = cur;
                cur = pre.next;
            }
        }
        return p.next;
    }
}

