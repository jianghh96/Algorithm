// 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，

// 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…

// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

// 示例 1:

// 给定链表 1->2->3->4, 重新排列为 1->4->2->3.

// 示例 2:

// 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.

// 递归

class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;
        ListNode node = head;
        while(node.next.next != null)
            node = node.next;
        ListNode end = node.next;
        ListNode start = head.next;
        head.next = end;
        node.next = null;
        end.next = start;
        reorderList(start);
    }
}

// 线性表存储链表节点

class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while(node != null){
            list.add(node);
            node = node.next;
        }
        int left = 0, right = list.size()-1;
        int sum = 0;
        while(left < right){
            if(sum % 2 == 0){
                list.get(left).next = list.get(right);
                left++;
            }else{
                list.get(right).next = list.get(left);
                right--;
            }
            sum++;
        }
        // 关键一步：断开连接，否则会出现环
        list.get(left).next = null;
    }
}

class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while(node != null){
            list.add(node);
            node = node.next;
        }
        int left = 0, right = list.size()-1;
        while(left < right){
            list.get(left).next = list.get(right);
            left++;
            if(left == right)
                break;
            list.get(right).next = list.get(left);
            right--;
        }
        // 关键一步：断开连接，否则会出现环
        list.get(left).next = null;
    }
}
