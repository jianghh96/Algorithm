// 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。

// 方法一：原地修改

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node p = head;
        while(p != null){
            Node pn = new Node(p.val);
            pn.next = p.next;
            p.next = pn;
            p = pn.next;
        }
        p = head;
        while(p != null){
            if(p.random != null)
                p.next.random = p.random.next;
            p = p.next.next;
        }
        p = head;
        Node pn = p.next;
        Node res = head.next;
        while(p != null){
            p.next = p.next.next;
            p = p.next;
            // 注意这里！
            if(pn.next != null){
                pn.next = pn.next.next;
                pn = pn.next;
            }
        }
        return res;
    }
}

// 哈希表

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        // map中存的是(原节点，拷贝节点)的一个映射
        Map<Node, Node> map = new HashMap<>();
        for (Node cur = head; cur != null; cur = cur.next) {
            map.put(cur, new Node(cur.val));
        }
        // 将拷贝的新的节点组织成一个链表
        for (Node cur = head; cur != null; cur = cur.next) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
        }

        return map.get(head);
    }
}
