class StockSpanner {

    //implemented myself
    Stack<Integer> stack;

    public StockSpanner() {
        this.stack = new Stack<Integer>();
    }
    
    public int next(int price) {
        int count = 1;
        List<Integer> cache = new ArrayList<>();

        while(!stack.isEmpty()){
            int val = stack.pop();
            if(val<=price){
                count++;
                cache.add(val);
            }else{
                stack.push(val); //chatgpt added this line
                break;
            }
        }

        //we need tp empty the cache and put the values back to stack
        for(int c: cache){
            stack.push(c);
        }

        //push the new value in as well
        stack.push(price);

        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */