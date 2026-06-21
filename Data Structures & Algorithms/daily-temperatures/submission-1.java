class Solution {
    public int[] dailyTemperatures_(int[] temperatures) {
        //create a stack of int array of size 2
        Stack<int[]> stack = new Stack<>();

        //res array
        int[] res = new int[temperatures.length];

        //push the first element in the stack
        int[] item = new int[2];
        item[0] = 0;
        item[1] = temperatures[0];
        stack.push(item);

        for(int i=0; i< temperatures.length; i++){

            //dont want to pop in an empty stack
            while(!stack.empty()){
                //pop the head
                int[] head = stack.pop();

                //check if the value is greater than the array val
                if(temperatures[i] > head[1]){
                    //get the diff of indeces
                    int index_diff = i - head[0];

                    //put the index_diff in the head[0]th place in the res array
                    int destination_index = head[0];

                    res[destination_index] = index_diff;

                    //put the new value in
                    int[] item0 = new int[2];
                    item0[0] = i;
                    item0[1] = temperatures[i];
                    stack.push(item0);

                }else{

                    //first put back the value we just popped
                    stack.push(head);

                    //second push the new value in the stack
                    int[] item1 = new int[2];
                    item1[0] = i;
                    item1[1] = temperatures[i];
                    stack.push(item1);

                    break;
                }
            }
        }

        return res;

    }

    //chatgpt
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[temperatures.length];

        // push first element
        stack.push(new int[]{0, temperatures[0]});

        // start from index 1 to avoid duplicate
        for (int i = 1; i < temperatures.length; i++) {

            // resolve previous smaller temperatures
            while (!stack.empty() && temperatures[i] > stack.peek()[1]) {
                int[] head = stack.pop();
                res[head[0]] = i - head[0];
            }

            // push current element ONCE
            stack.push(new int[]{i, temperatures[i]});
        }

        return res;
    }
}
