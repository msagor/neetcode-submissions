class MyStack {

    Queue<Integer> queue;
    public MyStack() {
        queue = new LinkedList<>();
    }
    
    public void push(int x) {
        queue.add(x);
    }
    
    public int pop() {
        return pop_gpt();
    }

    public int pop_gpt(){
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int elem = queue.poll();
            if (i != size - 1) {
                queue.offer(elem);
            } else {
                return elem;
            }
        }
        return -1;
    }
    
    public int top() {
        for(int i=0; i< queue.size(); i++){
            int elem = queue.poll();
            queue.offer(elem);
            if(i==queue.size()-1){
                return elem;
            }
        }
        return -1;
    }
    
    public boolean empty() {
        return queue.size()==0?true:false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */