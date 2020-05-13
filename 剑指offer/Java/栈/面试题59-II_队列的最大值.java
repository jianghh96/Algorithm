// 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。

// 若队列为空，pop_front 和 max_value 需要返回 -1

// 示例 ：

// 输入: 
// ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
// [[],[1],[2],[],[],[]]
// 输出: [null,null,null,2,1,2]

class MaxQueue {
    private Queue<Integer> queue1;
    private LinkedList<Integer> queue2;
    public MaxQueue() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    public int max_value() {
        if(queue1.isEmpty()) return -1;
        return queue2.peekFirst();
    }
    
    public void push_back(int value) {
        queue1.add(value);
        // 注意这里
        while(!queue2.isEmpty() && queue2.peekLast() < value){
            queue2.pollLast();
        }
        queue2.addLast(value);
    }
    
    public int pop_front() {
        if(queue1.isEmpty())
            return -1;
        int popNum = queue1.poll();
        if(queue2.peekFirst() == popNum)
            queue2.pollFirst();
        return popNum;
    }
}
