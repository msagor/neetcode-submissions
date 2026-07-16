//watched the solution and code, then types myself
class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();

        int open = 0;
        int close = 0;
        Stack<String> stack = new Stack<>();

        backtracking(n, open, close, stack, res);

        return res;
    }

    public void backtracking(int n, int open, int close, Stack<String> stack, List<String> res){
        //check if open and close equals to n
        if(open==n && close==n){
            //we ran out of braces
            //so we return
            String r = "";
            for(String s: stack){
                r = r + s;
            }

            res.add(r);
            return;    
        }
        
        if(open < n){
            //we have more open braces to spare
            //(that means we have more close bracecs to spare as well)
            stack.push("(");

            backtracking(n, open+1, close, stack, res);

            stack.pop();   
        }
        
        if(close < open){
            //we ran out of open braces but we have more close bracecs to spare
            stack.push(")");

            backtracking(n, open, close+1, stack, res);

            stack.pop();
        }
    }


}
