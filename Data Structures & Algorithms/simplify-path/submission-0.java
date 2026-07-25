
//chatgpt fixed this soution
class Solution {

    public String simplifyPath(String path) {
        
        //trying this solution without using split function
        Stack<String> stack = new Stack<>();

        //first char is / for root
        int idx = 1;
        String token = "";
        while(idx < path.length()){
            char c = path.charAt(idx);

            if(c != '/'){
                token = token + c;

                //regular increment of index
                idx++;
            }else{
                //we have reached a non-root /
                //by now token should have one of two options -
                //a word, single dot, or double dot.
                //we treat triple or more dots as a word.
                if(token.equals(".")){
                    //ignore
                }else if(token.equals("..")){
                    //double dot so we pop one from the stack
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                }else if(!token.equals("")){
                    //this is a valid token
                    stack.push(token);
                }

                //we move index to the place where the next token starts
                while(idx < path.length() && path.charAt(idx) == '/'){
                    idx++;
                }

                //refresh token string for next iteration
                token = "";
            }
        }

        //process the last token if the path does not end with '/'
        //i was missing this block entirely
        if(token.equals(".")){
            //ignore
        }else if(token.equals("..")){
            if(!stack.isEmpty()){
                stack.pop();
            }
        }else if(!token.equals("")){
            stack.push(token);
        }

        //if stack is empty, we are at root
        if(stack.isEmpty()){
            return "/";
        }

        String res = "";
        for(String s : stack){
            res = res + "/" + s;
        }

        return res;
    }
}