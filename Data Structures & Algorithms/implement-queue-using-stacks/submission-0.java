class MyQueue {
        Stack<Integer> pushStack;
        Stack<Integer> popStack;

    public MyQueue() {
        this.pushStack = new Stack<Integer>();
        this.popStack = new Stack<Integer>();
    }
    
    public void push(int x) {
        pushStack.push(x);
    }
    
    public int pop() {
        if(popStack.isEmpty()){
            //pop all from pushStack and push them in popStack
            while(!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }

        //pop the top value (first value in FIFO queue)
        return popStack.pop();
    }
    
    public int peek() {
        int val = this.pop();

        popStack.push(val);

        return val;
    }
    
    public boolean empty() {
        return popStack.isEmpty() && pushStack.isEmpty();
    }   
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */