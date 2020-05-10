// 输入两个链表，找出它们的第一个公共节点。

// 方法1

public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) return null;
    ListNode pA = headA, pB = headB;
    while (pA != pB) {
        pA = pA == null ? headB : pA.next;
        pB = pB == null ? headA : pB.next;
    }
    return pA;
}

// 方法2

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
