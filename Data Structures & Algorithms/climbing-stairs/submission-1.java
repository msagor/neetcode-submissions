class Solution {
    public int climbStairs(int n) {
        //we start at the bottom of the stairs to i == 0
        return dfs(n, 0);
    }

    public int dfs(int n, int i){
        if (i==n){
            //we reached the top so
            //there exacty one way to reach top
            return 1;
        }else if(i>n){
            //we over-climbed
            return 0;
        }else{
            // from the 0th step,
            // we can climb 1 step or 2 step
            // so at any step i, we can climb,
            // i+1 or i+2
            return dfs(n, i+1) + dfs(n, i+2);
        }
    }
}
