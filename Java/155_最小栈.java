// 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

// push(x) —— 将元素 x 推入栈中。
// pop() —— 删除栈顶的元素。
// top() —— 获取栈顶元素。
// getMin() —— 检索栈中的最小元素。

// 提示：pop、top 和 getMin 操作总是在 非空栈 上调用。

// 借助辅助栈存放最小元素

class MinStack {
    
    Stack<Integer> stack;
    // 使用一个辅助栈！
    Stack<Integer> stackhp;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        stackhp = new Stack<>();
    }
    
    public void push(int x) {
        stack.add(x);
        if(stackhp.isEmpty() || stackhp.peek() >= x){
            stackhp.add(x);
        }else{
            stackhp.add(stackhp.peek());
        }
    }
    
    public void pop() {
        if(!stack.isEmpty()){
            stack.pop();
            stackhp.pop();
        }
    }
    
    public int top() {
        if(!stack.isEmpty()){
            return stack.peek();
        }else{
            return 0;
        }
    }
    
    public int getMin() {
        if(!stack.isEmpty()){
            return stackhp.peek();
        }else{
            return 0;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
 
