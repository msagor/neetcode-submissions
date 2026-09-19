
//implemented myself with some debugging help from chatGPT
class MyCircularQueue {

    class Node{
        int val;
        Node previous;
        Node next;
        public Node(int val){
            this.val = val;
            previous = null;
            next = null;
        }
    }

    Node head = null;
    Node tail = null;
    int capacity=0;
    int count = 0;

    public MyCircularQueue(int k) {
        this.head = new Node(-1);
        this.tail = new Node(-1);
        head.next = tail;
        tail.previous = head;
        this.capacity = k;
    }
    
    public boolean enQueue(int value) {
        if(count>=capacity){
            return false;
        }

        Node newNode = new Node(value);

        if(count==0){
            head.next = newNode;
            tail.previous = newNode;

            newNode.previous = head;
            newNode.next = tail;
        }else{
            newNode.previous = tail.previous;
            newNode.next = tail;

            tail.previous.next = newNode;
            tail.previous = newNode;
        }
        count++;
        return true;
    }
    
    public boolean deQueue() {
        if(count==0){
            return false;
        }else if(count>0){
            head.next = head.next.next;
            head.next.previous = head;
            count--;
            return true;
        }

        return false;
    }
    
    public int Front() {
        return head.next.val;
    }
    
    public int Rear() {
        return tail.previous.val;
    }
    
    public boolean isEmpty() {
        return count==0;
    }
    
    public boolean isFull() {
        return count==capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */