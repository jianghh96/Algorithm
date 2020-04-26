// 编写一个程序，找到两个单链表相交的起始节点。

// 注意：

// 如果两个链表没有交点，返回 null.
// 在返回结果后，两个链表仍须保持原有的结构。
// 可假定整个链表结构中没有循环。
// 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。

// 非常巧妙！

public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) return null;
    ListNode pA = headA, pB = headB;
    while (pA != pB) {
        pA = pA == null ? headB : pA.next;
        pB = pB == null ? headA : pB.next;
    }
    return pA;
}


// 长的链表先走，再一起走

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        int lenA = 0;
        int lenB = 0;
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while(nodeA != null){
            lenA++;
            nodeA = nodeA.next;
        }
        while(nodeB != null){
            lenB++;
            nodeB = nodeB.next;
        }
        if(lenA >= lenB){
            for(int i = 0; i < lenA - lenB; i++){
                headA = headA.next;
            }
            for(int i = 0; i < lenB; i++){
                if(headA == headB){
                    return headA;
                }else{
                    headA = headA.next;
                    headB = headB.next;
                }
            }
        }else{
            for(int i = 0; i < lenB - lenA; i++){
                headB = headB.next;
            }
            for(int i = 0; i < lenA; i++){
                if(headA == headB){
                    return headA;
                }else{
                    headA = headA.next;
                    headB = headB.next;
                }
            }
        }
        return null;
    }
}
