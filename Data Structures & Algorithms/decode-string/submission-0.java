class Solution {
    //watched video then implemented myself
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i< s.length(); i++){
            char c= s.charAt(i);
            
            if(c != ']'){
                stack.push(c);
            }else{
                //we have reached a closing bracket
                //we need to keep popping until we reach the starting bracket
                String subS = "";

                while(stack.peek()!='['){
                    subS = subS + stack.pop() + "";
                }

                //reverse subS
                subS = new StringBuilder(subS).reverse().toString();

                //pop the [ (nothing to do with it)
                char opening_Brach = stack.pop();

                //now keep poppping the numbers
                String subD =  "";

                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    subD = subD + stack.pop();
                }

                //reverse the number string
                subD = new StringBuilder(subD).reverse().toString();

                //convert string to number
                int subD_int = Integer.parseInt(subD);

                //push subS string into the stack subD_int times
                for(int ii=0; ii< subD_int; ii++){
                    for(int j=0; j< subS.length(); j++  ){
                        stack.push(subS.charAt(j));
                    }
                }
            }
        }

        String res = "";
        for(char c: stack){
            res = res + (c + "");
        }

        return res;
    }
}