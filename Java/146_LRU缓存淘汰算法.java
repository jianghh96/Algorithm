// 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。

// 实现 LRUCache 类：

// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？

// 示例：

// 输入:
// ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
// [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
// 输出:
// [null, null, null, 1, null, -1, null, -1, 3, 4]

// 解释:
// LRUCache lRUCache = new LRUCache(2);
// lRUCache.put(1, 1); // 缓存是 {1=1}
// lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
// lRUCache.get(1);    // 返回 1
// lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
// lRUCache.get(2);    // 返回 -1 (未找到)
// lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
// lRUCache.get(1);    // 返回 -1 (未找到)
// lRUCache.get(3);    // 返回 3
// lRUCache.get(4);    // 返回 4

class LRUCache {
    class Node{
        public int key, val;
        public Node next, pre;

        public Node(int k, int v){
            this.key = k;
            this.val = v;
        }
    }
    
    class DoubleList{
        private Node head, tail;
        private int size;

        public void addFirst(Node node){
            if(head == null){
                head = node;
                tail = node;
            }else{
                Node h = head;
                node.next = h;
                h.pre = node;
                head = node;
            }
            size++;
        }
        public void remove(Node node) {
            if(head == node && tail == node){
                head = null;
                tail = null;
            }else if(head == node){
                node.next.pre = null;
                head = node.next;
            }else if(tail == node){
                node.pre.next = null;
                tail = node.pre;
            }else{
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            size--;
        }
        public Node removeLast(){
            Node node = tail;
            remove(tail);
            return node;
        }
        public int size(){
            return size;
        }
    }
    
    private HashMap<Integer, Node> map;
    private DoubleList list;
    private int capacity;
    
    public LRUCache(int capacity) {
        map = new HashMap<>();
        list = new DoubleList();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        int val = map.get(key).val;
        put(key, val);
        return val;
    }
    
    public void put(int key, int value) {
        Node node = new Node(key, value);
        if(map.containsKey(key)){
            list.remove(map.get(key));
            list.addFirst(node);
            map.put(key, node);
        }else{
            if(list.size() == capacity){
                Node tail = list.removeLast();
                map.remove(tail.key);
            }
            list.addFirst(node);
            map.put(key, node);
        }
    }
}
