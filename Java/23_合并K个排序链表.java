// 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

// 输入:
// [
//   1->4->5,
//   1->3->4,
//   2->6
// ]
// 输出: 1->1->2->3->4->4->5->6

// 分治思想

// 合并数组中第k个链表到第1个链表，合并数组中第k-1个链表到第2个链表，依次这样操作...
// 一轮合并之后，新链表分布在数组的 第1 到 第(k+1)/2个链表中，继续1这样的合并直到新链表只在数组第一个位置。
// 返回数组第一个元素，即合并之后的链表。

// 整体时间复杂度为O(N*log(k)), k为链表个数，N为链表数组中节点总个数；空间复杂度O(1)。

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(n == 0)
            return null;
        while(n > 1){
            for(int i = 0; i < n/2; i++){
                lists[i] = mergeTwoLists(lists[i], lists[n-1-i]);
            }
            n = (n+1)/2;
        }
        return lists[0];
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0);
        ListNode p = head;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                p.next = l1;
                l1 = l1.next;
            }else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if(l1 != null)
            p.next = l1;
        if(l2 != null)
            p.next = l2;
        return head.next;
    }
}
