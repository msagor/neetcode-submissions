class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;

        for(String t: tokens){
            if(!t.equals("+") && !t.equals("-") && !t.equals("*") && !t.equals("/")){
                //its a number
                //push the number in the stack
                stack.push(Integer.parseInt(t));
            }else{
                //its one of the symbols
                //we need to pop two numbers from the stack
                int num2 = stack.pop();
                int num1 = stack.pop();

                if(t.equals("+")){
                    //add
                    res = num1 + num2;
                    
                }else if(t.equals("-")){
                    //subtract 
                    res = num1 - num2;

                }else if(t.equals("*")){
                    //multiply
                    res = num1*num2;

                }else if(t.equals("/")){
                    //divide
                    res = num1/num2;
                }

                //push the result in the stack
                stack.push(res);
            }
        }

        return stack.pop();

    }
}
