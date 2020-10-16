// 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。

// 要求返回这个链表的深拷贝。 

// 我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：

// val：一个表示 Node.val 的整数。
// random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。

// 示例 ：

// 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
// 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]

// 哈希表

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        Map<Node, Node> map = new HashMap<>();
        Node node1 = head;
        while(node1 != null){
            Node node2 = new Node(node1.val);
            map.put(node1, node2);
            node1 = node1.next;
        }
        node1 = head;
        while(node1 != null){
            map.get(node1).next = map.get(node1.next);   // 注意这里
            map.get(node1).random = map.get(node1.random);
            node1 = node1.next;
        }
        return map.get(head);
    }
}

// 原地

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        Node node1 = head;
        while(node1 != null){
            Node node2 = new Node(node1.val);
            Node next = node1.next;
            node1.next = node2;
            node2.next = next;
            node1 = next;
        }
        node1 = head;
        while(node1 != null){
            // 注意这里
            node1.next.random = node1.random == null ? null : node1.random.next;
            node1 = node1.next.next;
        }
        node1 = head;
        Node copyHead = head.next;
        while(node1.next != null){
            Node node2 = node1.next;
            node1.next = node2.next;
            node1 = node2;
        }
        return copyHead;
    }
}
